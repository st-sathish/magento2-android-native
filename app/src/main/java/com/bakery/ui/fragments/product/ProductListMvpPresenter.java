package com.bakery.ui.fragments.product;

import com.bakery.presenter.MvpPresenter;

public interface ProductListMvpPresenter<V extends ProductListMvp> extends MvpPresenter<V> {

    void pickProducts();

    void loadNextPage();
}
