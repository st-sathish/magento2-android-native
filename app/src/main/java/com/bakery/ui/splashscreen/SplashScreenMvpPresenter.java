package com.bakery.ui.splashscreen;

import com.bakery.presenter.MvpPresenter;

public interface SplashScreenMvpPresenter <V extends SplashScreenMvpView> extends MvpPresenter<V> {

    void fetchCategories();
}
