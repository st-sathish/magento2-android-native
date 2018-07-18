package com.bakery.ui.login;

import com.androidnetworking.error.ANError;
import com.bakery.R;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.presenter.BasePresenter;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter <V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    @Override
    public void onLoginBtnClick(String email, String password) {
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        Map<String, String> body = new HashMap<>();
        body.put("username", email);
        body.put("password", password);
        Rx2AndroidNetworking
                .post(ApiEndpoints.LOGIN_API)
                .addApplicationJsonBody(body)
                .build()
                .getObjectObservable(String.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String accessToken) {
                        getMvpView().openMainActivity();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (e instanceof ANError) {
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
