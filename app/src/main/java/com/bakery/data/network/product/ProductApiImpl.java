package com.bakery.data.network.product;

import com.bakery.data.db.domain.Cart;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.ProductListResponse;
import com.bakery.data.network.models.ProductResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Observable;

public class ProductApiImpl implements ProductApi {

    @Override
    public Observable<ProductListResponse> getProductDetailListByCategoryId(int currentPage, int pageSize, int categoryId) {
        return Rx2AndroidNetworking.get(ApiEndpoints.API_GET_PRODUCTS)
                .addHeaders("Content-Type", "application/json")
                .addQueryParameter("searchCriteria[pageSize]", String.valueOf(pageSize))
                .addQueryParameter("searchCriteria[currentPage]", String.valueOf(currentPage))
                .addQueryParameter("searchCriteria[filter_groups][0][filters][0][field]", "category_id")
                .addQueryParameter("searchCriteria[filter_groups][0][filters][0][value]", String.valueOf(categoryId))
                .build()
                .getObjectObservable(ProductListResponse.class);
    }

    @Override
    public Observable<Cart> addCartApi(CartRequest cartRequest) {
        return Rx2AndroidNetworking
                .post(ApiEndpoints.API_POST_ADD_CART)
                .addHeaders("Content-Type", "application/json")
                .addHeaders("Authorization", "Bearer"+" ")
                .addBodyParameter(cartRequest)
                .build()
                .getObjectObservable(Cart.class);
    }

    @Override
    public Observable<ProductResponse> getProductBySku(String productSkuId) {
        return Rx2AndroidNetworking
                .get(ApiEndpoints.API_GET_PRODUCTS+"/{productSkuId}")
                .addHeaders("Content-Type", "application/json")
                .addPathParameter("productSkuId", productSkuId)
                .build()
                .getObjectObservable(ProductResponse.class);
    }
}
