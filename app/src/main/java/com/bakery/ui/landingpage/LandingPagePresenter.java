package com.bakery.ui.landingpage;

import com.bakery.data.db.domain.CartList;
import com.bakery.presenter.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LandingPagePresenter <V extends LandingPageMvpView> extends BasePresenter<V> implements LandingPageMvpPresenter<V> {

    @Override
    public void getCartList() {
        getDataManager().getCartItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartList cartList) {
                        getMvpView().updateCartCount(String.valueOf(cartList.getItemsCount()));
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
