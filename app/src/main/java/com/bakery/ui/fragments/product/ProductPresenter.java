package com.bakery.ui.fragments.product;

import android.support.annotation.NonNull;

import com.androidnetworking.error.ANError;
import com.bakery.data.SessionStore;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.ApiProductDetail;
import com.bakery.data.network.models.ApiStockKeepingUnit;
import com.bakery.presenter.BasePresenter;
import com.bakery.utils.AppConstants;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ProductPresenter <V extends ProductMvp> extends BasePresenter<V> implements ProductMvpPresenter<V> {

    private int page;

    public ProductPresenter() {
        this.page = 0;
    }

    @Override
    public void pickProducts() {
        //flatMapProduct();
        mkCategorySkuListApi();
    }

    @Override
    public void loadNextPage() {
        if(page != 0) {
            // increase the page
            page += 1;
        }
        getProductsBySku(SessionStore.sStockKeepingUnits.subList(page, AppConstants.PAGINATION_LIMIT));
    }

    private void mkCategorySkuListApi() {
        Rx2AndroidNetworking
                .get(ApiEndpoints.API_GET_CATEGORIES+"/{categoryId}/products")
                .addHeaders("Content-Type", "application/json")
                .addPathParameter("categoryId", String.valueOf(SessionStore.sSelectedCategory.getId()))
                .build()
                .getObjectListObservable(ApiStockKeepingUnit.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ApiStockKeepingUnit>>() {

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
                    public void onNext(List<ApiStockKeepingUnit> stockKeepingUnits) {
                            SessionStore.sStockKeepingUnits = stockKeepingUnits;
                    }

                    @Override
                    public void onComplete() {
                        loadNextPage();
                    }
                });
    }

    private void getProductsBySku(List<ApiStockKeepingUnit> skus) {
        final List<ApiProductDetail> productDetails = new ArrayList<>();

        Observable.fromIterable(skus)
                .flatMap(new Function<ApiStockKeepingUnit, ObservableSource<ApiProductDetail>>() {
                    @Override
                    public ObservableSource<ApiProductDetail> apply(ApiStockKeepingUnit apiStockKeepingUnit) throws Exception {
                        return getProductDetailsObservable(apiStockKeepingUnit.getSku());
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

                    }

                    @Override
                    public void onNext(ApiProductDetail apiProductDetail) {
                       productDetails.add(apiProductDetail);
                    }

                    @Override
                    public void onComplete() {
                        getMvpView().hideLoading();
                        getMvpView().update(productDetails);
                    }
                });
    }

//    /**
//     * Get list of product by category
//     * @return Observable
//     */
//    private Observable<List<ApiStockKeepingUnit>> getCategorySkuListObservable(Integer categoryId) {
//        return Rx2AndroidNetworking
//                .get(ApiEndpoints.API_GET_CATEGORIES+"/{categoryId}/products")
//                .addHeaders("Content-Type", "application/json")
//                .addPathParameter("categoryId", String.valueOf(categoryId))
//                .build()
//                .getObjectListObservable(ApiStockKeepingUnit.class);
//    }

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

//    private void flatMapProduct() {
//        getCategorySkuListObservable(SessionStore.sSelectedCategory.getId())
//                .flatMap(new Function <List<ApiStockKeepingUnit>, Observable<ApiStockKeepingUnit>>() {
//                    @Override
//                    public Observable<ApiStockKeepingUnit> apply(List<ApiStockKeepingUnit> apiStockKeepingUnits) {
//                        return Observable.fromIterable(apiStockKeepingUnits);
//                    }
//                })
//                .flatMap(new Function<ApiStockKeepingUnit, Observable<ApiProductDetail>>() {
//                    @Override
//                    public Observable<ApiProductDetail> apply(ApiStockKeepingUnit apiStockKeepingUnit) {
//                        return getProductDetailsObservable(apiStockKeepingUnit.getSku());
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ApiProductDetail>() {
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if (!isViewAttached()) {
//                            return;
//                        }
//
//                        getMvpView().hideLoading();
//
//                        // handle the login error here
//                        if (e instanceof ANError) {
//                            ANError anError = (ANError) e;
//                            handleApiError(anError);
//                        }
//                    }
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        getMvpView().showLoading();
//                    }
//
//                    @Override
//                    public void onNext(ApiProductDetail apiProductDetail) {
//                        getMvpView().hideLoading();
//                        getMvpView().update(apiProductDetail);
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}
