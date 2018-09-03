package com.bakery.ui.fragments.mycart;

import com.androidnetworking.error.ANError;
import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.CartResponse;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.BasePresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MyCartPresenter<V extends MyCartMvpView> extends BasePresenter<V> implements MyCartMvpPresenter<V> {
    @Override
    public void getCartItems() {
        getMvpView().showLoading();
        getDataManager().getCartItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartListResponse cartListResponse) {
                        getMvpView().update(cartListResponse);
                        //iterateCartList(cartListResponse.getItems());
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!isViewAttached()) {
                            return;
                        }

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

    private void iterateCartList(List<CartResponse> items) {
        Observable.just(items)
                .flatMap(new Function<List<CartResponse>, Observable<CartResponse>>() {
                    @Override
                    public Observable<CartResponse> apply(List<CartResponse> cartResponses) {
                        return Observable.fromIterable(cartResponses);
                    }
                }).flatMap(new Function<CartResponse, Observable<ProductResponse>>() {
            @Override
            public Observable<ProductResponse> apply(CartResponse cartResponse) {
                return getDataManager().getProductBySku(cartResponse.getSku());
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductResponse productResponse) {
                        getMvpView().getProductCallback(productResponse);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



}
