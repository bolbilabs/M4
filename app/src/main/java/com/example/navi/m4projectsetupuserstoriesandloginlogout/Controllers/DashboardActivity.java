package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.navi.m4projectsetupuserstoriesandloginlogout.R;

public class DashboardActivity extends AppCompatActivity {

    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomeScreenIntent = new Intent(DashboardActivity.this, com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers.WelcomeScreen.class);
                startActivity(welcomeScreenIntent);
            }
        });
    }

}
