package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 */
public class RegisterActivity extends AppCompatActivity {
    private boolean cancel = false;
    private boolean processing = false;

    private boolean isUsernameValid(String username) {
        return !username.isEmpty();
    }

    private boolean isPasswordValid(String password) {
        return !password.isEmpty();
    }

    @Override
    public void onBackPressed() {
        cancel = true;
        super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Switch etAdmin = (Switch) findViewById(R.id.etAdmin);

        final Button bRegister = (Button) findViewById(R.id.bRegister);
        final Button bCancel = (Button) findViewById(R.id.bCancel);

        final ProgressBar pbLoading = (ProgressBar) findViewById(R.id.pbLoading);
        pbLoading.setVisibility(View.INVISIBLE);



        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final int admin = (etAdmin.isChecked()) ? 1 : 0;

                cancel = false;
                View focusView = null;

                // Check for a valid username address.
                if (TextUtils.isEmpty(username)) {
                    etUsername.setError(getString(R.string.error_field_required));
                    focusView = etUsername;
                    cancel = true;
                } else if (!isUsernameValid(username)) {
                    etUsername.setError(getString(R.string.error_invalid_username));
                    focusView = etUsername;
                    cancel = true;
                }

                // Check for a valid password, if the user entered one.
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError(getString(R.string.error_field_required));
                    focusView = etPassword;
                    cancel = true;
                } else if (!isPasswordValid(password)) {
                    etPassword.setError(getString(R.string.error_invalid_password));
                    focusView = etPassword;
                    cancel = true;
                }

                if (cancel) {
                    focusView.requestFocus();
                } else if (!processing) {
                    processing = true;
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                pbLoading.setVisibility(View.INVISIBLE);

                                if (success) {
                                    Intent intent = new Intent(RegisterActivity.this,
                                            LoginActivity.class);
                                    RegisterActivity.this.startActivity(intent);
                                    processing = false;

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog
                                            .Builder(RegisterActivity.this);
                                    builder.setMessage("Sorry, this username is already taken.")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                    cancel = true;
                                    processing = false;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                processing = false;
                            }
                        }
                    };


                    RegisterRequest registerRequest = new RegisterRequest(username, password,
                            admin, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);

                    pbLoading.setVisibility(View.VISIBLE);


                    new CountDownTimer(30000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            if (!cancel) {
                                cancel = true;
                                processing = false;
                                pbLoading.setVisibility(View.INVISIBLE);
                                AlertDialog.Builder builder = new AlertDialog
                                        .Builder(RegisterActivity.this);
                                builder.setMessage("Unable to communicate with the server."
                                        + " Please check your connection and try again later.")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        }
                    }.start();
                }
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, WelcomeScreen.class);
                RegisterActivity.this.startActivity(intent);
            }
        });
    }
}
