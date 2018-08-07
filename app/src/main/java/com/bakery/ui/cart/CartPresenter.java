package com.bakery.ui.cart;

import com.bakery.data.db.domain.Cart;
import com.bakery.data.db.domain.CartList;
import com.bakery.data.network.models.CartRequest;
import com.bakery.presenter.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CartPresenter extends BasePresenter implements CartMvpPresenter {

    private CartPresenterResponseCallback callback = null;

    @Override
    public void checkCart() {
        getDataManager().getCartItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartList cartList) {
                        if(callback == null) {
                            return;
                        }
                        callback.cartListSuccessCallback(cartList);
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
    public void createEmptyCart() {
        getDataManager().createEmptyCart()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String quoteId) {
                        if(callback == null) {
                            return;
                        }
                        callback.createEmptyCartSuccessCallback(quoteId);
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
    public void addCart(CartRequest request) {
        getDataManager().addItemCart(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Cart>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Cart cart) {
                        if(callback == null) {
                            return;
                        }
                        callback.addItemCartSuccessCallback(cart);
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
    public void removeCart(String itemId) {
        getDataManager().deleteCartItem(itemId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean b) {
                        if(callback == null) {
                            return;
                        }
                        callback.removeItemCartSuccessCallback(b);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void setOnCartResponseCallback(CartPresenterResponseCallback callback) {
        this.callback = callback;
    }

    public interface CartPresenterResponseCallback {

        void cartListSuccessCallback(CartList cartList);

        void createEmptyCartSuccessCallback(String quoteId);

        void addItemCartSuccessCallback(Cart cart);

        void removeItemCartSuccessCallback(boolean isRemoved);
    }
}
