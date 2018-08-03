package com.bakery.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.Map;

import io.reactivex.Observable;

public class GeneralApiImpl implements GeneralApi {

    @Override
    public Observable<String> login(Map<String, String> body) {
        return Rx2AndroidNetworking
                .post(ApiEndpoints.LOGIN_API)
                .addApplicationJsonBody(body)
                .build()
                .getObjectObservable(String.class);
    }
}
