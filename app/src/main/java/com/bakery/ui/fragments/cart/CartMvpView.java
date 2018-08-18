package com.bakery.ui.fragments.cart;

import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.CartResponse;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.MvpView;

import java.util.List;

public interface CartMvpView extends MvpView {

    void addCartCallback(CartResponse cartResponse);

    void getCartProductsCallback(List<ProductResponse> productResponses);

    void removeCartCallback(Boolean b);

    void getProductCallback(ProductResponse productResponse);

    void updateBadge(Integer qty);
}
