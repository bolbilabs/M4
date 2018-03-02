package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.navi.m4projectsetupuserstoriesandloginlogout.R;

public class DashboardActivity extends AppCompatActivity {

    private Button logoutButton;
    private Button shelterButton;
    private String username;
    private int admin;
    private boolean restore = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TextView dashboardWelcomeText = findViewById(R.id.DashboardWelcomeText);
        final TextView dashboardAdminText = findViewById(R.id.DashboardAdminText);
        

        Intent intent = getIntent();

        if (intent.getStringExtra("username") != null) {
            username = intent.getStringExtra("username");
            admin = intent.getIntExtra("admin", 0);


            dashboardWelcomeText.setText("Welcome to the Dashboard, " + username + "!");

            if (admin == 1) {
                dashboardAdminText.setText("You are currently an Admin!");
            } else {
                dashboardAdminText.setText("You are currently a User.");
            }
        } else {
            String rUsername = savedInstanceState.getString("username");
            int rAdmin = savedInstanceState.getInt("admin");
            dashboardWelcomeText.setText("Welcome to the Dashboard, " + rUsername + "!");

            if (rAdmin == 1) {
                dashboardAdminText.setText("You are currently an Admin!");
            } else {
                dashboardAdminText.setText("You are currently a User.");
            }
        }
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

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("username", username);
        savedInstanceState.putInt("admin",admin);
        savedInstanceState.putBoolean("restore", restore);
        super.onSaveInstanceState(savedInstanceState);

    }


}
