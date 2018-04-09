package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Puts the most current reserved beds, the shelter it's reserving in question, and the
 * username in the database.
 *
 * Created by dfriedman32 on 3/19/18.
 */

public class ReleaseRequest extends StringRequest {
        private static final String RELEASE_REQUEST_URL = "http://136.59.225.27/Release.php";
    //private static final String RELEASE_REQUEST_URL = "http://192.168.1.19/Release.php";
//    private static final String RELEASE_REQUEST_URL = "http://98.252.206.56/Release.php";

    private Map<String, String> params;

    public ReleaseRequest(int reservedBeds, int reservedShelter_id, String username,
                          Response.Listener<String> listener) {
        super(Method.POST, RELEASE_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("reservedBeds",reservedBeds + "");
//        params.put("password",password);
        params.put("reservedShelter_id",reservedShelter_id + "");
        params.put("username",username);
    }


    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
