package com.bakery.ui.landingpage;

import com.bakery.presenter.MvpView;

public interface LandingPageMvpView extends MvpView {

    void updateCartCount(String count);
}
