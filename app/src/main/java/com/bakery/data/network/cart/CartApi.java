package com.bakery.data.network.cart;

import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.CartResponse;

import io.reactivex.Observable;

public interface CartApi {

    Observable<CartListResponse> getItems();

    Observable<CartResponse> addItem(CartRequest request);

    Observable<String> createEmpty();

    Observable<Boolean> deleteItem(String itemId);
}
