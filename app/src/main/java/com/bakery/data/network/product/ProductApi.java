package com.bakery.data.network.product;

import com.bakery.data.network.models.ProductListResponse;
import com.bakery.data.network.models.ProductResponse;

import java.util.List;

import io.reactivex.Observable;

public interface ProductApi {

    /**
     * Get product list by api
     * @param pageSize
     *      page size default 10
     * @param currentPage
     *      current page default 1
     * @param categoryId
     *      selected category id
     * @return
     *      list of product detail list
     */
    Observable<ProductListResponse> getProductDetailListByCategoryId(int currentPage, int pageSize, int categoryId);
}
