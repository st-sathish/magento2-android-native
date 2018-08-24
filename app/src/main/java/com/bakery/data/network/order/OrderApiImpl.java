package com.bakery.data.network.order;

import com.bakery.data.SessionStore;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.OrderRequest;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Observable;

public class OrderApiImpl implements OrderApi {

    @Override
    public Observable<String> placeOrder(OrderRequest order) {
        return Rx2AndroidNetworking.post(ApiEndpoints.API_PLACE_ORDER)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .addApplicationJsonBody(order)
                .build()
                .getObjectObservable(String.class);
    }

}
