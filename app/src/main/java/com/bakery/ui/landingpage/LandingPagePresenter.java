package com.bakery.ui.landingpage;

import com.bakery.data.db.domain.CartOverview;
import com.bakery.presenter.BasePresenter;
import com.bakery.ui.cart.CartMvpPresenter;
import com.bakery.ui.cart.CartPresenter;

public class LandingPagePresenter <V extends LandingPageMvpView> extends BasePresenter<V> implements LandingPageMvpPresenter<V>, CartPresenter.OnCartItemsCallback {

    @Override
    public void getCartList() {
        CartMvpPresenter cartMvpPresenter = new CartPresenter();
        cartMvpPresenter.getCartItems(this);
    }

    @Override
    public void onCartListSuccess(CartOverview cartOverview) {
        getMvpView().updateCartCount(String.valueOf(cartOverview.getItemsCount()));
    }
}
