package com.bakery.data.network.order;

import com.bakery.data.SessionStore;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.AddressModel;
import com.bakery.data.network.models.OrderRequest;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class OrderApiImpl implements OrderApi {

    @Override
    public Observable<String> placeOrder(OrderRequest order) {
        return Rx2AndroidNetworking.post(ApiEndpoints.API_PLACE_ORDER)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .addApplicationJsonBody(order)
                .build()
                .getObjectObservable(String.class);
    }

    @Override
    public Observable<JSONObject> setAddress(AddressModel address) {
        return Rx2AndroidNetworking.post(ApiEndpoints.API_SET_BILLING_SHIPPING_ADDRESS)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer " + SessionStore.accessToken)
                .addApplicationJsonBody(address)
                .build()
                .getObjectObservable(JSONObject.class);
    }
}
