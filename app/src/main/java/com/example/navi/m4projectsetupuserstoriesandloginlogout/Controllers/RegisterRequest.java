package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dfriedman32 on 2/17/18.
 */

class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://136.59.225.27/Register.php";
    //private static final String REGISTER_REQUEST_URL = "http://192.168.1.19/Register.php";
    //private static final String REGISTER_REQUEST_URL = "http://98.252.206.56/Register.php";

    private Map<String, String> params;

    public RegisterRequest(String username, String password, int admin,
                           Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
//        params.put("password",password);
        params.put("admin",admin + "");
    }


    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
