package com.bakery.ui.signup;

import com.androidnetworking.error.ANError;
import com.bakery.R;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.presenter.BasePresenter;
import com.bakery.utils.ValidationUtils;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONArray;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SignUpPresenter<V extends SignUpMvpView> extends BasePresenter<V> implements SignUpMvpPresenter<V> {

    @Override
    public void onRegisterBtnClick(String email, String firstName, String lastName,
                                   String password, String phone) {
        if (firstName == null || firstName.isEmpty()) {
            getMvpView().onError(R.string.empty_first_name);
            return;
        }
        if (lastName == null || lastName.isEmpty()) {
            getMvpView().onError(R.string.empty_last_name);
            return;
        }
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if(!ValidationUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        JSONObject body = new JSONObject();
        try {
            JSONObject customer = new JSONObject();
            customer.put("email", email);
            customer.put("firstname", firstName);
            customer.put("lastname", lastName);
            JSONArray attributes = new JSONArray();
            JSONObject attr = new JSONObject();
            attr.put("attribute_code", "custom_phone");
            attr.put("value", phone);
            attributes.put(attr);
            customer.put("custom_attributes", attributes);
            body.put("customer", customer);
            body.put("password", password);
            // make REST Call post request
            mkSignUpRequest(body);
        } catch(Exception e) {

        }
    }

    private void mkSignUpRequest(JSONObject body) {
        getMvpView().showLoading();
        Rx2AndroidNetworking
                .post(ApiEndpoints.API_POST_CUSTOMER_SIGNUP)
                .addHeaders("Content-Type", "application/json")
                .addApplicationJsonBody(body)
                .build()
                .getJSONObjectObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JSONObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JSONObject response) {
                        getMvpView().hideLoading();
                        getMvpView().openLandingPageActivity();
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
