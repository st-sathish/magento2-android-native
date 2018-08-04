package com.bakery.ui.fragments.product;

import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.MvpView;

import java.util.List;

public interface ProductListMvp extends MvpView {

     void update(List<ProductResponse> productResponses);

     void stopEndlessLoading();

     void showEndlessSpinner();

     void hideEndlessSpinner();
}
