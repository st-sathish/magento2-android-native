package com.bakery.data.network.product;

import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.ApiProductDetail;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.List;

import io.reactivex.Observable;

public class ProductApiImpl implements ProductApi {

    @Override
    public Observable<List<ApiProductDetail>> getProductDetailListByCategoryId(int currentPage, int pageSize, int categoryId) {
        return Rx2AndroidNetworking.get(ApiEndpoints.API_GET_PRODUCTS)
                .addHeaders("Content-Type", "application/json")
                .addPathParameter("searchCriteria[pageSize]", String.valueOf(pageSize))
                .addPathParameter("searchCriteria[currentPage]", String.valueOf(currentPage))
                .addPathParameter("searchCriteria[filter_groups][0][filters][0][field]", "category_id")
                .addPathParameter("searchCriteria[filter_groups][0][filters][0][value]", String.valueOf(categoryId))
                .build()
                .getObjectListObservable(ApiProductDetail.class);
    }
}
