package com.bakery.ui.fragments.product.detail;

import com.androidnetworking.error.ANError;
import com.bakery.data.SessionStore;
import com.bakery.data.db.domain.Cart;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.BasePresenter;
import com.bakery.ui.cart.CartPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ProductDetailPresenter <V extends ProductDetailMvp> extends BasePresenter<V> implements ProductDetailMvpPresenter<V>, CartPresenter.OnAddItemCartCallback {

    private CartPresenter mCartPresenter;

    public ProductDetailPresenter() {
        mCartPresenter = new CartPresenter();
    }

    @Override
    public void setViewValue(ProductResponse mProductDetail) {
        if(!isViewAttached()) {
            return;
        }
        getMvpView().setProductName(mProductDetail.getName());
        getMvpView().setProductPrice(String.valueOf(mProductDetail.getPrice()));
        for(ProductResponse.CustomAttribute customAttribute: mProductDetail.getCustomAttributes()) {
            if(customAttribute.getAttributeCode().equals("description")) {
                getMvpView().setDescription(String.valueOf(customAttribute.getValue()));
            }
            if(customAttribute.getAttributeCode().equals("short_description")) {
                getMvpView().setShortDescription(String.valueOf(customAttribute.getValue()));
            }
        }
    }

    @Override
    public void getProductRelatedLinks(List<ProductResponse.ProductLink> productLinks) {
        final List<ProductResponse> productResponses = new ArrayList<>();
        getMvpView().showHorizontalProgressBar();
        Observable.fromIterable(productLinks)
                .flatMap(new Function<ProductResponse.ProductLink, ObservableSource<ProductResponse>>() {
                    @Override
                    public ObservableSource<ProductResponse> apply(ProductResponse.ProductLink link) {
                        System.out.print(link.getSku());
                        return getDataManager().getProductBySku(link.getSku());
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
                        getMvpView().onRelatedProductsSuccess(productResponses);
                        getMvpView().hideHorizontalProgressBar();
                    }
                });
    }

    @Override
    public void addCart(final String quantity, final String sku) {
        final Integer qty = Integer.parseInt(quantity);
        getMvpView().showLoading();
        if(SessionStore.quoteId == 0) {
            mCartPresenter.createEmptyCart(new CartPresenter.EmptyCartCallback() {
                @Override
                public void onEmptyCartCallback() {
                    CartRequest cartRequest = new CartRequest(new CartRequest.CartItem(SessionStore.quoteId, sku, qty));
                    mCartPresenter.addCart(cartRequest, ProductDetailPresenter.this);
                }
            });
        } else {
            CartRequest cartRequest = new CartRequest(new CartRequest.CartItem(SessionStore.quoteId, sku, qty));
            mCartPresenter.addCart(cartRequest, this);
        }
    }

    @Override
    public void increaseQuantity(String quantity) {
        int qty = Integer.valueOf(quantity);
        if(qty < 0) {
            getMvpView().updateQuantity("0");
            return;
        }
        qty += 1;
        getMvpView().updateQuantity(String.valueOf(qty));
    }

    @Override
    public void decreaseQuantity(String quantity) {
        int qty = Integer.valueOf(quantity);
        if(qty <= 0) {
            getMvpView().updateQuantity("0");
            return;
        }
        qty -= 1;
        getMvpView().updateQuantity(String.valueOf(qty));
    }

    @Override
    public void onCartItemAdded() {
        getMvpView().switchProductListFragment(1);
        getMvpView().hideLoading();
    }
}
