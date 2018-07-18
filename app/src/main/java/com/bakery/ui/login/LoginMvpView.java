package com.bakery.ui.login;

import android.view.View;

import com.bakery.presenter.MvpView;

public interface LoginMvpView extends MvpView {

    void openLandingPageActivity();

    void onForgotPasswordClick(View v);

    void onNewAccountClick(View v);
}
