package com.bakery.ui.fragments.cart;

import com.androidnetworking.error.ANError;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.CartResponse;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class CartPresenter <V extends CartMvpView> extends BasePresenter<V> implements CartMvpPresenter<V> {

    @Override
    public void getCartItems() {
        getDataManager().getCartItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartListResponse cartListResponse) {
                        getMvpView().updateBadge(cartListResponse.getItemsQty());
                        iterateCartList(cartListResponse.getItems());
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

    @Override
    public void addCart(final CartRequest request) {
        if(SessionStore.quoteId == 0) {
            getDataManager().createEmptyCart()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(String quoteId) {
                            SessionStore.quoteId = Integer.parseInt(quoteId);
                            addItemToCart(request);
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

                        }
                    });
        } else {
            addItemToCart(request);
        }
    }

    private void addItemToCart(CartRequest request) {
        request.getCartItem().setQuoteId(SessionStore.quoteId);
        getDataManager().addItemCart(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartResponse cartResponse) {
                        getMvpView().addCartCallback(cartResponse);
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

                    }
                });
    }

    @Override
    public void removeCart(Integer itemId) {
        getDataManager().deleteCartItem(itemId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean b) {
                        getMvpView().removeCartCallback(b);
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

                    }
                });
    }

    @Override
    public void getProductsBySku(String sku) {
        getDataManager().getProductBySku(sku)
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
                       getMvpView().getProductCallback(productResponse);
                    }

                    @Override
                    public void onComplete() {
                        getMvpView().hideLoading();
                    }
                });
    }
}
