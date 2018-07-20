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
        Rx2AndroidNetworking
                .get(ApiEndpoints.API_GET_CATEGORIES)
                .addHeaders("Content-Type", "application/json")
                .build()
                .getObjectObservable(CategoryResponse.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryResponse categoryResponse) {
                        SessionStore.categoryResp = categoryResponse;
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached() && e instanceof ANError) {
                            ANError anError = (ANError) e;
                            handleApiError(anError);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
