package com.bakery.ui.fragments.product.detail;

import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.MvpPresenter;
import com.bakery.presenter.MvpView;

public interface ProductDetailMvpPresenter <V extends MvpView> extends MvpPresenter<V> {

    void setViewValue(ProductResponse mProductDetail);
}
