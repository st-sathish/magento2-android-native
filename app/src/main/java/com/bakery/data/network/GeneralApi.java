package com.bakery.data.network;

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
    Observable signUp();
}
