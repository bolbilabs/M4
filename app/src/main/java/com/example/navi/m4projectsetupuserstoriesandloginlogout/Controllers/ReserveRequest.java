package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dfriedman32 on 3/19/18.
 */

public class ReserveRequest extends StringRequest {
        private static final String RESERVE_REQUEST_URL = "http://136.59.225.27/Reserve.php";
    //private static final String RESERVE_REQUEST_URL = "http://192.168.1.19/Register.php";
//    private static final String RESERVE_REQUEST_URL = "http://98.252.206.56/Reserve.php";

    private Map<String, String> params;

    /**
     *
     * @param reservedBeds number of reserved bed
     * @param reservedShelter_id number of shelter's id
     * @param username the username
     * @param listener the listener
     */
    public ReserveRequest(int reservedBeds, int reservedShelter_id, String username,
                          Response.Listener<String> listener) {
        super(Method.POST, RESERVE_REQUEST_URL, listener, null);
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
