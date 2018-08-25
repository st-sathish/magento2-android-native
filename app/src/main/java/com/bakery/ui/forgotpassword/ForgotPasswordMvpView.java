package com.bakery.ui.forgotpassword;

import android.view.View;

import com.bakery.presenter.MvpView;

public interface ForgotPasswordMvpView extends MvpView {

    void onExistingUserClick();

    void onContinueButtonClick(View v);

    void onForgotPasswordSuccessEmail();

}
