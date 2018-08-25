package com.bakery.data.network.security;

import com.bakery.data.SessionStore;
import com.bakery.data.network.ApiEndpoints;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;

public class SecurityApiImpl implements SecurityApi {

    @Override
    public Observable<JSONObject> signUp(JSONObject body) {
        return Rx2AndroidNetworking
                .post(ApiEndpoints.API_POST_CUSTOMER_SIGNUP)
                .addHeaders("Content-Type", "application/json")
                .addApplicationJsonBody(body)
                .build()
                .getJSONObjectObservable();
    }

    @Override
    public Observable<String> login(Map<String, String> body) {
        return Rx2AndroidNetworking
                .post(ApiEndpoints.LOGIN_API)
                .addApplicationJsonBody(body)
                .build()
                .getObjectObservable(String.class);
    }

    @Override
    public Observable<Boolean> forgotPassword(Map<String, String> body) {
        return Rx2AndroidNetworking
                .put(ApiEndpoints.RESET_PWD_API)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .addApplicationJsonBody(body)
                .build()
                .getObjectObservable(Boolean.class);
    }

}
