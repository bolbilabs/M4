package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dfriedman32 on 2/17/18.
 */

public class ShelterDataRequest extends StringRequest {
    //    private static final String SHELTER_REQUEST_URL = "http://136.59.225.27/Register.php";
    private static final String SHELTER_REQUEST_URL = "http://192.168.1.19/ShelterRequest.php";

    public ShelterDataRequest(Response.Listener<String> listener) {
        super(Method.POST, SHELTER_REQUEST_URL, listener, null);
    }
}

