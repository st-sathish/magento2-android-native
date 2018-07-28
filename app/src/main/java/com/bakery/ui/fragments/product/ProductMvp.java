package com.bakery.ui.fragments.product;

import com.bakery.data.network.models.ApiProductDetail;
import com.bakery.presenter.MvpView;

import java.util.List;

public interface ProductMvp extends MvpView {

     void update(List<ApiProductDetail> apiProductDetails);

     void loadNextPage();
}
