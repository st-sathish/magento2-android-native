package com.bakery.data.network.cart;

import com.bakery.data.SessionStore;
import com.bakery.data.db.domain.Cart;
import com.bakery.data.db.domain.CartOverview;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.CartRequest;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Observable;

public class CartApiImpl implements CartApi {

    @Override
    public Observable<CartOverview> getItems() {
        return Rx2AndroidNetworking.get(ApiEndpoints.API_GET_AND_CREATE_EMPTY_CART)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .build()
                .getObjectObservable(CartOverview.class);
    }

    @Override
    public Observable<Cart> addItem(CartRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoints.API_POST_ADD_CART)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .addApplicationJsonBody(request)
                .build()
                .getObjectObservable(Cart.class);
    }

    @Override
    public Observable<String> createEmpty() {
        return Rx2AndroidNetworking.post(ApiEndpoints.API_GET_AND_CREATE_EMPTY_CART)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .build()
                .getObjectObservable(String.class);
    }

    @Override
    public Observable<Boolean> deleteItem(String itemId) {
        return Rx2AndroidNetworking.delete(ApiEndpoints.API_DELETE_CART_ITEM)
                .addHeaders(ApiEndpoints.HEADER_AUTHORIZATION, "Bearer "+ SessionStore.accessToken)
                .addPathParameter("itemId", itemId)
                .build()
                .getObjectObservable(Boolean.class);
    }
}
