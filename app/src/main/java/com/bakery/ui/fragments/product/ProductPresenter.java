package com.bakery.ui.fragments.product;

import com.androidnetworking.error.ANError;
import com.bakery.data.SessionStore;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.ApiProductDetail;
import com.bakery.data.network.models.ApiProduct;
import com.bakery.presenter.BasePresenter;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ProductPresenter <V extends ProductMvp> extends BasePresenter<V> implements ProductMvpPresenter<V> {

    @Override
    public void pickProducts() {
        flatMapProduct();
    }

    /**
     * Get list of product by category
     * @return Observable
     */
    private Observable<List<ApiProduct>> getCategorySkuListObservable(Integer categoryId) {
        return Rx2AndroidNetworking
                .get(ApiEndpoints.API_GET_CATEGORIES+"/{categoryId}/products")
                .addHeaders("Content-Type", "application/json")
                .addPathParameter("categoryId", String.valueOf(categoryId))
                .build()
                .getObjectListObservable(ApiProduct.class);
    }

    /**
     * Get list of product details by product sku id
     * @return Observable
     */
    private Observable<ApiProductDetail> getProductDetailsObservable(String productSkuId) {
        return Rx2AndroidNetworking
                .get(ApiEndpoints.API_GET_PRODUCTS+"/{productSkuId}")
                .addHeaders("Content-Type", "application/json")
                .addPathParameter("productSkuId", productSkuId)
                .build()
                .getObjectObservable(ApiProductDetail.class);
    }

    private void flatMapProduct() {
        getCategorySkuListObservable(SessionStore.sSelectedCategory.getId())
                .flatMap(new Function <List<ApiProduct>, Observable<ApiProduct>>() {
                    @Override
                    public Observable<ApiProduct> apply(List<ApiProduct> apiProducts) {
                        return Observable.fromIterable(apiProducts);
                    }
                })
                .flatMap(new Function<ApiProduct, Observable<ApiProductDetail>>() {
                    @Override
                    public Observable<ApiProductDetail> apply(ApiProduct apiProduct) {
                        return getProductDetailsObservable(apiProduct.getSku());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiProductDetail>() {

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
                    public void onSubscribe(Disposable d) {
                        getMvpView().showLoading();
                    }

                    @Override
                    public void onNext(ApiProductDetail apiProductDetail) {
                        getMvpView().hideLoading();
                        getMvpView().update(apiProductDetail);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
