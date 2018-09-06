package com.bakery.ui.landingpage;

import com.bakery.data.network.models.CartRequest;
import com.bakery.presenter.MvpPresenter;

public interface LandingPageMvpPresenter <V extends LandingPageMvpView> extends MvpPresenter<V> {

    void getCartList();

    void addCart(final CartRequest request);
}
