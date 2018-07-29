package com.bakery.data;

import com.bakery.data.network.models.ApiProductDetail;
import com.bakery.data.network.models.ApiStockKeepingUnit;
import com.bakery.data.network.models.CategoryResponse;

import java.util.Collections;
import java.util.List;

public final class SessionStore {

    public static List<CategoryResponse> sSelectedExpandableCategory = null;

    public static CategoryResponse sSelectedCategory = null;

    public static List<ApiStockKeepingUnit> sStockKeepingUnits = Collections.emptyList();

    public static ApiProductDetail productDetail = null;

    private SessionStore() {

    }
}
