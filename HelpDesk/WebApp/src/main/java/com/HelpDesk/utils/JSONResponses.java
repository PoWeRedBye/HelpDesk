package com.HelpDesk.utils;


import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

/**
 * Created by Maxim_Ozarovskiy on 20.02.2017.
 */
public final class JSONResponses {
    public static final JSONStreamAware ERROR_INCORRECT_REQUEST;

    static {
        JSONObject response = new JSONObject();
        response.put("errorCode", 1);
        response.put("errorDescription", "Incorrect request");
        ERROR_INCORRECT_REQUEST = JSON.prepare(response);
    }
}
