package com.bakery.ui.fragments.product.detail;

import com.bakery.presenter.MvpView;

public interface ProductDetailMvp extends MvpView {

    void setDescription(String description);

    void setShortDescription(String shortDescription);

    void setProductName(String productName);

    void setProductPrice(String productPrice);
}
