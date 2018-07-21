package com.bakery.ui.fragments.drawer;

import com.bakery.presenter.MvpPresenter;

public interface FragmentDrawerMvpPresenter <V extends FragmentDrawerMvpView> extends MvpPresenter<V> {

    void fetchCategories();
}
