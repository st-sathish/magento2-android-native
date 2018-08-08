package com.bakery.data;

import com.bakery.data.network.models.ProductResponse;
import com.bakery.data.network.models.StockKeepingUnitResponse;
import com.bakery.data.network.models.CategoryResponse;

import java.util.Collections;
import java.util.List;

public final class SessionStore {

    public static List<CategoryResponse> sSelectedExpandableCategory = null;

    public static CategoryResponse sSelectedCategory = null;

    public static List<StockKeepingUnitResponse> sStockKeepingUnits = Collections.emptyList();

    public static ProductResponse productDetail = null;

    public static String accessToken = "";

    public static int quoteId = 0;

    private SessionStore() {

    }
}
