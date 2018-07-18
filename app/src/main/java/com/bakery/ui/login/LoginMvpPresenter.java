package com.bakery.ui.login;

import com.bakery.presenter.MvpPresenter;

public interface LoginMvpPresenter <V extends LoginMvpView> extends MvpPresenter<V> {

    void onLoginBtnClick(String email, String password);

}
