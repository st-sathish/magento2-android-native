package com.bakery.ui.splashscreen;

import com.androidnetworking.error.ANError;
import com.bakery.data.SessionStore;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.CategoryResponse;
import com.bakery.presenter.BasePresenter;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SplashScreenPresenter extends BasePresenter implements SplashScreenMvpPresenter {

    @Override
    public void fetchCategories() {

    }
}
