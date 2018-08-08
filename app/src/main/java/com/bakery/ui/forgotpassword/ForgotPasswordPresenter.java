package com.bakery.ui.forgotpassword;

import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.bakery.R;
import com.bakery.data.network.security.SecurityApi;
import com.bakery.data.network.security.SecurityApiImpl;
import com.bakery.presenter.BasePresenter;
import com.bakery.utils.ValidationUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForgotPasswordPresenter<V extends ForgotPasswordMvpView> extends BasePresenter<V> implements ForgotPasswordMvpPresenter<V> {

    SecurityApi securityApi;


    public ForgotPasswordPresenter() {
        securityApi = new SecurityApiImpl();
    }

    public void onResetPasswordClick(String email) {
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
        }

        getMvpView().showLoading();
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("template", "email_reset");
        body.put("websiteId", "1");
        securityApi.forgotPassword(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String response) {
                        getMvpView().hideLoading();
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
                        getMvpView().hideLoading();
                   }
                });
    }

}
