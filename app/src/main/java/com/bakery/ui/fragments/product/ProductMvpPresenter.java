package com.bakery.ui.fragments.product;

import com.bakery.presenter.MvpPresenter;

public interface ProductMvpPresenter<V extends ProductMvp> extends MvpPresenter<V> {

    void pickProducts();

    void loadNextPage();
}
