package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by dfriedman32 on 2/17/18.
 *
 *
 */

public class ShelterDataRequest extends StringRequest {
        private static final String SHELTER_REQUEST_URL = "http://136.59.225.27/ShelterRequest.php";
    //private static final String SHELTER_REQUEST_URL = "http://192.168.1.19/ShelterRequest.php";
//    private static final String SHELTER_REQUEST_URL = "http://98.252.206.56/ShelterRequest.php";

    /**
     * @param listener the url concerning the database
     */
    public ShelterDataRequest(Response.Listener<String> listener) {
        super(Method.POST, SHELTER_REQUEST_URL, listener, null);
    }
}

