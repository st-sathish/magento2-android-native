package com.bakery.ui.fragments.mycart;

import com.bakery.data.network.models.CartRequest;
import com.bakery.presenter.MvpPresenter;

public interface MyCartMvpPresenter<V extends MyCartMvpView> extends MvpPresenter<V> {

    void getCartItems();

    void removeCart(Integer itemId);

    void addItemToCart(CartRequest request);
}
