package com.bakery.ui.fragments.mycart;

import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.MvpView;

import java.util.List;

public interface MyCartMvpView extends MvpView {

    void update(CartListResponse cartListResponses);

    void getProductCallback(ProductResponse productResponse);

    void removeCartCallback(Boolean b);
}
