package com.bakery.ui.cart;

import com.bakery.data.network.models.CartRequest;
import com.bakery.presenter.MvpPresenter;

public interface CartMvpPresenter extends MvpPresenter {

    void getCartItems(final CartPresenter.OnCartItemsCallback callback);

    void createEmptyCart(CartPresenter.EmptyCartCallback emptyCartCallback);

    void addCart(CartRequest request, CartPresenter.OnAddItemCartCallback callback);

    void removeCart(String itemId);
}
