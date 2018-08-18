package com.bakery.data.network.cart;

import com.bakery.data.SessionStore;
import com.bakery.data.db.domain.Cart;
import com.bakery.data.db.domain.CartOverview;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.CartResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.Map;
import java.util.WeakHashMap;

import io.reactivex.Observable;

public class CartApiImpl implements CartApi {

    @Override
    public Observable<CartListResponse> getItems() {
        return Rx2AndroidNetworking.get(ApiEndpoints.API_GET_AND_CREATE_EMPTY_CART)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .build()
                .getObjectObservable(CartListResponse.class);
    }

    @Override
    public Observable<CartResponse> addItem(CartRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoints.API_POST_ADD_CART)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .addApplicationJsonBody(request)
                .build()
                .getObjectObservable(CartResponse.class);
    }

    @Override
    public Observable<String> createEmpty() {
        return Rx2AndroidNetworking.post(ApiEndpoints.API_GET_AND_CREATE_EMPTY_CART)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .build()
                .getObjectObservable(String.class);
    }

    @Override
    public Observable<Boolean> deleteItem(Integer itemId) {
        return Rx2AndroidNetworking.delete(ApiEndpoints.API_DELETE_CART_ITEM)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .addPathParameter("itemId", String.valueOf(itemId))
                .build()
                .getObjectObservable(Boolean.class);
    }
}
