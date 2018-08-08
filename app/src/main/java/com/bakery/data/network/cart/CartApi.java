package com.bakery.data.network.cart;

import com.bakery.data.db.domain.Cart;
import com.bakery.data.db.domain.CartOverview;
import com.bakery.data.network.models.CartRequest;

import io.reactivex.Observable;

public interface CartApi {

    Observable<CartOverview> getItems();

    Observable<Cart> addItem(CartRequest request);

    Observable<String> createEmpty();

    Observable<Boolean> deleteItem(String itemId);
}
