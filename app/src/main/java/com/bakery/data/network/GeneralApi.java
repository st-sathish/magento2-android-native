package com.bakery.data.network;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;

public interface GeneralApi {

    /**
     * Login
     * @param body
     *      request body
     * @return
     *      Observable
     */
    Observable<String> login(Map<String, String> body);

    /**
     * Signup
     * @return
     *      Observable
     */
    Observable signUp(JSONObject body);
}