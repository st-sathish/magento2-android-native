package com.bakery.ui.fragments.product;

import com.androidnetworking.error.ANError;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.ProductListResponse;
import com.bakery.data.network.product.ProductApi;
import com.bakery.data.network.product.ProductApiImpl;
import com.bakery.presenter.BasePresenter;
import com.bakery.utils.AppConstants;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductListPresenter<V extends ProductListMvp> extends BasePresenter<V> implements ProductListMvpPresenter<V> {

    private int page;

    private int pageSize = AppConstants.PAGINATION_LIMIT;

    private ProductApi productApi;

    public ProductListPresenter() {
        this.page = 0;
        this.productApi = new ProductApiImpl();
    }

    @Override
    public void pickProducts() {
        //flatMapProduct();
        //mkCategorySkuListApi();
        getProductList();
    }

    private void getProductList() {
        this.productApi.getProductDetailListByCategoryId(page, pageSize, SessionStore.sSelectedCategory.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getMvpView().showEndlessSpinner();
                    }

                    @Override
                    public void onNext(ProductListResponse productListResponse) {
                        if(productListResponse.getItems().size() == 0) {
                            getMvpView().stopEndlessLoading();
                            return;
                        }
                        getMvpView().update(productListResponse.getItems());
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
                        getMvpView().hideEndlessSpinner();
                        page += 1;
                    }
                });
    }

    @Override
    public void loadNextPage() {
//        getProductsBySku(SessionStore.sStockKeepingUnits.subList(page, pageSize));
//        if(SessionStore.sStockKeepingUnits.size() > pageSize) {
//            page = (pageSize + 1);
//            pageSize += pageSize;
//        } else {
//            getMvpView().stopEndlessLoading();
//        }
        getProductList();
    }

//    private void mkCategorySkuListApi() {
//        Rx2AndroidNetworking
//                .get(ApiEndpoints.API_GET_CATEGORIES+"/{categoryId}/products")
//                .addHeaders("Content-Type", "application/json")
//                .addPathParameter("categoryId", String.valueOf(SessionStore.sSelectedCategory.getId()))
//                .build()
//                .getObjectListObservable(StockKeepingUnitResponse.class)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<StockKeepingUnitResponse>>() {
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
//                    public void onNext(List<StockKeepingUnitResponse> stockKeepingUnits) {
//                            SessionStore.sStockKeepingUnits = stockKeepingUnits;
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        loadNextPage();
//                    }
//                });
//    }
//
//    private void getProductsBySku(List<StockKeepingUnitResponse> skus) {
//        final List<ProductResponse> productDetails = new ArrayList<>();
//
//        Observable.fromIterable(skus)
//                .flatMap(new Function<StockKeepingUnitResponse, ObservableSource<ProductResponse>>() {
//                    @Override
//                    public ObservableSource<ProductResponse> apply(StockKeepingUnitResponse apiStockKeepingUnit) throws Exception {
//                        return getProductDetailsObservable(apiStockKeepingUnit.getSku());
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ProductResponse>() {
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
//
//                    }
//
//                    @Override
//                    public void onNext(ProductResponse productResponse) {
//                       productDetails.add(productResponse);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        getMvpView().hideLoading();
//                        getMvpView().update(productDetails);
//                    }
//                });
//    }

//    /**
//     * Get list of product by category
//     * @return Observable
//     */
//    private Observable<List<StockKeepingUnitResponse>> getCategorySkuListObservable(Integer categoryId) {
//        return Rx2AndroidNetworking
//                .get(ApiEndpoints.API_GET_CATEGORIES+"/{categoryId}/products")
//                .addHeaders("Content-Type", "application/json")
//                .addPathParameter("categoryId", String.valueOf(categoryId))
//                .build()
//                .getObjectListObservable(StockKeepingUnitResponse.class);
//    }

//    /**
//     * Get list of product details by product sku id
//     * @return Observable
//     */
//    private Observable<ProductResponse> getProductDetailsObservable(String productSkuId) {
//        return Rx2AndroidNetworking
//                .get(ApiEndpoints.API_GET_PRODUCTS+"/{productSkuId}")
//                .addHeaders("Content-Type", "application/json")
//                .addPathParameter("productSkuId", productSkuId)
//                .build()
//                .getObjectObservable(ProductResponse.class);
//    }

//    private void flatMapProduct() {
//        getCategorySkuListObservable(SessionStore.sSelectedCategory.getId())
//                .flatMap(new Function <List<StockKeepingUnitResponse>, Observable<StockKeepingUnitResponse>>() {
//                    @Override
//                    public Observable<StockKeepingUnitResponse> apply(List<StockKeepingUnitResponse> apiStockKeepingUnits) {
//                        return Observable.fromIterable(apiStockKeepingUnits);
//                    }
//                })
//                .flatMap(new Function<StockKeepingUnitResponse, Observable<ProductResponse>>() {
//                    @Override
//                    public Observable<ProductResponse> apply(StockKeepingUnitResponse apiStockKeepingUnit) {
//                        return getProductDetailsObservable(apiStockKeepingUnit.getSku());
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ProductResponse>() {
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
//                    public void onNext(ProductResponse apiProductDetail) {
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
