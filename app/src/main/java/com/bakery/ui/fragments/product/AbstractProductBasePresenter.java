package com.bakery.ui.fragments.product;

import com.androidnetworking.error.ANError;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.data.network.product.ProductApi;
import com.bakery.data.network.product.ProductApiImpl;
import com.bakery.presenter.BasePresenter;
import com.bakery.presenter.MvpPresenter;
import com.bakery.presenter.MvpView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

// we use this later whenever necessary to make this call again & again in different screens
public abstract class AbstractProductBasePresenter <V extends MvpView> extends BasePresenter<V> implements MvpPresenter<V> {

    private final ProductApi productApi = new ProductApiImpl();

    protected void getProductRelatedLinks(List<ProductResponse.ProductLink> productLinks) {
        final List<ProductResponse> productResponses = new ArrayList<>();
        Observable.fromIterable(productLinks)
                .flatMap(new Function<ProductResponse.ProductLink, ObservableSource<ProductResponse>>() {
                    @Override
                    public ObservableSource<ProductResponse> apply(ProductResponse.ProductLink link) {
                        return productApi.getProductBySku(link.getSku());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductResponse>() {

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
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductResponse productResponse) {
                        productResponses.add(productResponse);
                    }

                    @Override
                    public void onComplete() {
                        productRespCallback(productResponses);
                    }
                });
    }

    public abstract void productRespCallback(List<ProductResponse> productResponses);
}
