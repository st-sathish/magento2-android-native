package com.bakery.data.network.security;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;

public interface SecurityApi {

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
    Observable<JSONObject> signUp(JSONObject body);
}
