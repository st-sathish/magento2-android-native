package com.bakery.ui.fragments.product.detail;

import android.view.View;

import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.MvpView;

import java.util.List;

public interface ProductDetailMvp extends MvpView {

    void setDescription(String description);

    void setShortDescription(String shortDescription);

    void setProductName(String productName);

    void setProductPrice(String productPrice);

    void onRelatedProductsSuccess(List<ProductResponse> relatedProducts);

    void showHorizontalProgressBar();

    void hideHorizontalProgressBar();
}
