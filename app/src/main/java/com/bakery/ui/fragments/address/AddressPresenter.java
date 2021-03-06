package com.bakery.ui.fragments.address;

import com.androidnetworking.error.ANError;
import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.AddressModel;
import com.bakery.data.network.models.OrderRequest;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.BasePresenter;
import com.bakery.ui.fragments.cart.CartPresenter;
import com.bakery.ui.fragments.product.detail.ProductDetailMvp;
import com.bakery.ui.fragments.product.detail.ProductDetailMvpPresenter;
import com.bakery.utils.ProductUtils;
import com.bakery.utils.ValidationUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AddressPresenter<V extends AddressMvp> extends BasePresenter<V> implements AddressMvpPresenter<V>{

    @Override
    public void placeOrder(OrderRequest order) {

            getMvpView().showLoading();

            getDataManager().placeOrder(order)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(String accessToken) {
                            SessionStore.accessToken = accessToken;
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
                            getMvpView().orderCallback();
                        }
                    });



    }

    @Override
    public void setAddress(AddressModel address) {

        getMvpView().showLoading();

        getDataManager().setAddress(address)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JSONObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JSONObject accessToken) {

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
                        getMvpView().addressCallback();
                    }
                });



    }

}
