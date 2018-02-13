package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.navi.m4projectsetupuserstoriesandloginlogout.R;

public class WelcomeScreen extends AppCompatActivity {

    private Button loginButton;
    private TextView registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_welcome_screen);

        loginButton = (Button) findViewById(R.id.loginButton);
        registration = (TextView) findViewById(R.id.newUser);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            Intent loginIntent = new Intent(WelcomeScreen.this, com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers.LoginActivity.class);
            startActivity(loginIntent);
            }
        });

        // Change the LoginActivity.class to the registration.class when the latter is complete
        registration.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(WelcomeScreen.this, com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers.LoginActivity.class);
                startActivity(registerIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
