package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.PreRegisteredShelters;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.Shelter;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.User;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.R;

import org.json.JSONException;
import org.json.JSONObject;

public class DashboardActivity extends AppCompatActivity {

    private Button logoutButton;
    private Button shelterButton;
    private Button mapButton;
    private Button releaseButton;

    private String username;
    private int admin;
    private int reservedBeds;
    private int reservedShelterID;

    private boolean restore = false;

    private boolean loaded = false;

    boolean cancel = false;

    private boolean processing;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TextView dashboardWelcomeText = findViewById(R.id.DashboardWelcomeText);
        final TextView dashboardAdminText = findViewById(R.id.DashboardAdminText);
        final TextView dashboardBedText = findViewById(R.id.DashboardBedText);
        final TextView shelterText = findViewById(R.id.shelterText);

        final PreRegisteredShelters preRegisteredShelters = PreRegisteredShelters.getInstance();
        processing = false;

        preRegisteredShelters.clearAllShelters();

        username = User.getUsername();
        admin = User.getAdmin();
        reservedBeds = User.getReservedBeds();
        reservedShelterID = User.getReservedShelterID();


        if (!loaded) {
                /*
                    CSV Reader: Uncomment if server is down.
                */
//            InputStream inputStream = getResources().openRawResource(+ R.raw.homeless_shelter_database);
//            try {
//                Scanner scan = new Scanner(inputStream, StandardCharsets.UTF_8.toString());
//                String line;
//                Shelter temp;
//                scan.nextLine(); //throw out first line
//                while (scan.hasNext()) {
//                    line = scan.nextLine();
//                    String[] tokens = line.split(",");
//                    temp = new Shelter(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4],
//                            tokens[5], tokens[6], tokens[7], tokens[8]);
//                    preRegisteredShelters.addShelter(temp);
//                }
//            } catch (Exception e) {
//
//            }
//            loaded = true;


            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonInitResponse = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                        boolean success = jsonInitResponse.getBoolean("success");
                        int shelterCount = jsonInitResponse.getInt("shelterCount");
                        if (success) {
                            // Show a progress spinner, and kick off a background task to
                            // perform the user login attempt.
                            //showProgress(false);
                            //mAuthTask = new UserLoginTask(username, password);
                            //mAuthTask.execute((Void) null);

                            Shelter temp;

                            for (int i = 0; i < shelterCount; i++) {

                                JSONObject jsonResponse = jsonInitResponse.getJSONObject(String.valueOf(i));

                                temp = new Shelter(String.valueOf(jsonResponse.getInt("shelter_id")), jsonResponse.getString("name"),
                                        String.valueOf(jsonResponse.getInt("capacity")), jsonResponse.getString("restrictions"),
                                        jsonResponse.getString("longitude"), jsonResponse.getString("latitude"),
                                        jsonResponse.getString("address"), jsonResponse.getString("notes"),
                                        jsonResponse.getString("phoneNumber"));
                                preRegisteredShelters.addShelter(temp);



                            }
                            loaded = true;

                            if (reservedShelterID == 0) {
                                shelterText.setText("View Shelter List to Select a Shelter.");
                            } else{
                                for(Shelter s: preRegisteredShelters.getShelters()) {
                                    if (reservedShelterID == Integer.parseInt(s.getKey())) {
                                        shelterText.setText("Shelter: " + s.getName());
                                    }
                                }
                            }

                        } else {
                            cancel = true;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        // showProgress(false);
                        cancel = true;

                    }

                }
            };

            ShelterDataRequest shelterDataRequest = new ShelterDataRequest(responseListener);
            RequestQueue queue = Volley.newRequestQueue(DashboardActivity.this);
            queue.add(shelterDataRequest);
        }
        






            dashboardWelcomeText.setText("Welcome to the Dashboard, " + username + "!");

            if (admin == 1) {
                dashboardAdminText.setText("You are currently an Admin!");
            } else {
                dashboardAdminText.setText("You are currently a User.");
            }
            dashboardBedText.setText("Current number of reserved beds: " + reservedBeds);

//            if (reservedShelterID == 0) {
//                shelterText.setText("View Shelter List to Select a Shelter.");
//            } else{
//                for(Shelter s: preRegisteredShelters.getShelters()) {
//                    if (reservedShelterID == Integer.parseInt(s.getKey())) {
//                        shelterText.setText("Shelter: " + s.getName());
//                    }
//                }
//            }


        logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomeScreenIntent = new Intent(DashboardActivity.this, com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers.WelcomeScreen.class);
                startActivity(welcomeScreenIntent);
            }
        });

        shelterButton = (Button) findViewById(R.id.shelterButton);
        shelterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shelterListScreenIntent = new Intent(DashboardActivity.this, com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers.ShelterListActivity.class);
                shelterListScreenIntent.putExtra("username", username);
                shelterListScreenIntent.putExtra("admin", admin);
                startActivity(shelterListScreenIntent);
            }
        });

        mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shelterMapScreenIntent = new Intent(DashboardActivity.this, com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers.MapActivity.class);
                shelterMapScreenIntent.putExtra("username", username);
                shelterMapScreenIntent.putExtra("admin", admin);
                startActivity(shelterMapScreenIntent);
            }
        });

        releaseButton = (Button) findViewById(R.id.bedReleaseButton);

        if (User.getReservedBeds() <= 0) {
            releaseButton.setVisibility(View.INVISIBLE);
        }

        releaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel = false;
                if (!processing) {
                    processing = true;
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (!cancel) {
                                try {
                                    JSONObject jsonResponse = new JSONObject(response);
                                    boolean success = jsonResponse.getBoolean("success");
                                    if (success) {
                                        User.setReservedShelterID(0);
                                        User.setReservedBeds(0);
                                        finish();
                                        startActivity(getIntent());
                                        processing = false;
                                        cancel = true;
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                                        builder.setMessage("An unknown error occurred.")
                                                .setNegativeButton("Retry", null)
                                                .create()
                                                .show();
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

                    ReleaseRequest releaseRequest = new ReleaseRequest(reservedBeds, reservedShelterID, username, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(DashboardActivity.this);
                    queue.add(releaseRequest);



                    new CountDownTimer(30000, 1000) {

                        public void onTick(long millisUntilFinished) {

                        }

                        public void onFinish() {
                            if (!cancel) {
                                cancel = true;
                                processing = false;
                                AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                                builder.setMessage("Unable to communicate with the server. Please check your connection and try again later.")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        }
                    }.start();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("username", username);
        savedInstanceState.putInt("admin",admin);
        savedInstanceState.putBoolean("restore", restore);
        super.onSaveInstanceState(savedInstanceState);

    }


}
