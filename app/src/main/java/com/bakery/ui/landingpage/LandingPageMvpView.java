package com.bakery.ui.landingpage;

import com.bakery.data.network.models.CartResponse;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.MvpView;

public interface LandingPageMvpView extends MvpView {

    void updateCartCount(String count);

    void doIncrementCartCount(Integer count);

    void addCartToMyAccount(ProductResponse response, String quantity);

    void cartAddedCallback(CartResponse cartResponse);
}
