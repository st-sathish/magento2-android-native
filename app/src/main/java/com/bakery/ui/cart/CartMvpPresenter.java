package com.bakery.ui.cart;

import com.bakery.data.network.models.CartRequest;
import com.bakery.presenter.MvpPresenter;

public interface CartMvpPresenter extends MvpPresenter {

    void checkCart();

    void createEmptyCart();

    void addCart(CartRequest request);

    void removeCart(String itemId);
}
