package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.PreRegisteredShelters;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.User;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * An activity representing a single Shelter detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ShelterListActivity}.
 */
public class ShelterDetailActivity extends AppCompatActivity {
    private EditText input;
    private boolean processing;
    private boolean cancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        final PreRegisteredShelters preRegisteredShelters = PreRegisteredShelters.getInstance();
        processing = false;
        cancel = false;


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Reserve Beds");
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setMessage("Number of Beds to Reserve:");
        input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);


        builder.setPositiveButton("Reserve", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cancel = true;
                dialogInterface.dismiss();
            }
        });

        final AlertDialog ad = builder.create();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (User.getReservedBeds() > 0) {
            fab.setVisibility(View.INVISIBLE);
        }


        fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                    ad.show();
                        ad.getButton(AlertDialog.BUTTON_POSITIVE)
                                .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                cancel = false;
                                if (!processing) {
                                    if (!(input.getText().toString().equals(""))
                                            && isReserveValid(Integer
                                            .parseInt(input.getText().toString()))) {
                                        processing = true;
                                        int reservedBeds = Integer
                                                .parseInt(input.getText().toString());
                                        int reservedShelter_id = Integer
                                                .parseInt(preRegisteredShelters.getCurrentShelter()
                                                        .getKey());
                                        String username = User.getUsername();


                                        Response.Listener<String> responseListener = new Response
                                                .Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (!cancel) {
                                                    try {
                                                        JSONObject jsonResponse =
                                                                new JSONObject(response);
                                                        boolean success = jsonResponse
                                                                .getBoolean("success");
                                                        if (success) {
                                                            String text = input
                                                                    .getText().toString();
                                                            User.setReservedBeds(Integer
                                                                    .parseInt(text));
                                                            finish();
                                                            User.setReservedShelterID(Integer
                                                                    .parseInt(preRegisteredShelters
                                                                            .getCurrentShelter()
                                                                            .getKey()));
                                                            Intent dashboardScreenIntent = new Intent(ShelterDetailActivity.this, com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers.DashboardActivity.class);
                                                            startActivity(dashboardScreenIntent);
                                                            ad.dismiss();
                                                            processing = false;
                                                            cancel = true;
                                                        } else {
                                                            input.setError("We're sorry, but your reservation exceeds maximum occupancy.");
                                                            processing = false;
                                                            cancel = true;

                                                        }
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                        processing = false;
                                                        cancel = true;
                                                    }
                                                }
                                            }
                                        };

                                        ReserveRequest reserveRequest =
                                                new ReserveRequest(reservedBeds, reservedShelter_id,
                                                         username, responseListener);
                                        RequestQueue queue = Volley
                                                .newRequestQueue(ShelterDetailActivity.this);
                                        queue.add(reserveRequest);

                                        new CountDownTimer(30000, 1000) {

                                            @Override
                                            public void onTick(long millisUntilFinished) {

                                            }

                                            @Override
                                            public void onFinish() {
                                                if (!cancel) {
                                                    cancel = true;
                                                    processing = false;
                                                    android.app.AlertDialog.Builder builder = new
                                                            android.app.AlertDialog.Builder(
                                                                    ShelterDetailActivity.this);
                                                    builder.setMessage("Unable to communicate with the server. Please check your connection and try again later.")
                                                            .setNegativeButton("Retry", null)
                                                            .create()
                                                            .show();

                                                }
                                            }
                                        }.start();


                                    } else {
                                        input.setError("Please enter a valid Bed count (1-6).");
                                    }
                                }
                            }
                        });

                }
            });

            // Show the Up button in the action bar.
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }



            // savedInstanceState is non-null when there is fragment state
            // saved from previous configurations of this activity
            // (e.g. when rotating the screen from portrait to landscape).
            // In this case, the fragment will automatically be re-added
            // to its container so we don't need to manually add it.
            // For more information, see the Fragments API guide at:
            //
            // http://developer.android.com/guide/components/fragments.html
            //
            if (savedInstanceState == null) {
                // Create the detail fragment and add it to the activity
                // using a fragment transaction.
                Bundle arguments = new Bundle();
                arguments.putString(ShelterDetailFragment.ARG_ITEM_ID,
                        getIntent().getStringExtra(ShelterDetailFragment.ARG_ITEM_ID));
                ShelterDetailFragment fragment = new ShelterDetailFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.shelter_detail_container, fragment)
                        .commit();
            }
    }


    private boolean isReserveValid(int reserveCount) {
        return (reserveCount > 0) && (reserveCount < 7);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ShelterListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
