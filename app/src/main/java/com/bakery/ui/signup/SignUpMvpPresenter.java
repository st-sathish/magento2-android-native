package com.bakery.ui.signup;

import com.bakery.presenter.MvpPresenter;

public interface SignUpMvpPresenter<V extends SignUpMvpView> extends MvpPresenter<V> {

    void onRegisterBtnClick(String email, String firstName, String lastName, String password, String phone);
}
