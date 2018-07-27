package com.bakery.ui.fragments.product;

import com.bakery.data.network.models.ApiProductDetail;
import com.bakery.presenter.MvpView;

public interface ProductMvp extends MvpView {

     void update(ApiProductDetail apiProductDetail);
}
