package com.bakery.ui.fragments.product;

import com.bakery.presenter.MvpPresenter;

public interface ProductDetailListMvpPresenter<V extends ProductDetailListMvp> extends MvpPresenter<V> {

    void pickProducts();

    void loadNextPage();
}
