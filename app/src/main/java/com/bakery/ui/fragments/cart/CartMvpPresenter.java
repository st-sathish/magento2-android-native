package com.bakery.ui.fragments.cart;

import com.bakery.data.network.models.CartRequest;
import com.bakery.presenter.MvpPresenter;

public interface CartMvpPresenter <V extends CartMvpView> extends MvpPresenter<V> {

    void getCartItems();

    void addCart(CartRequest request);

    void removeCart(Integer itemId);

    void getProductsBySku(String sku);
}
