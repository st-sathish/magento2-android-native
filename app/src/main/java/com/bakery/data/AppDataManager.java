package com.bakery.data;

import com.bakery.data.network.ApiHelper;
import com.bakery.data.network.AppApiHelper;
import com.bakery.data.network.models.ProductListResponse;
import com.bakery.data.network.models.ProductResponse;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;

public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;

    public AppDataManager() {
        apiHelper = new AppApiHelper();
    }

    @Override
    public Observable<JSONObject> signUp(JSONObject body) {
        return this.apiHelper.getSecurityApi().signUp(body);
    }

    @Override
    public Observable<String> login(Map<String, String> body) {
        return this.apiHelper.getSecurityApi().login(body);
    }

    @Override
    public Observable<ProductListResponse> getProductDetailListByCategoryId(int currentPage, int pageSize, int categoryId) {
        return this.apiHelper.getProductApi().getProductDetailListByCategoryId(currentPage, pageSize, categoryId);
    }

    @Override
    public Observable<ProductResponse> getProductBySku(String productSkuId) {
        return this.apiHelper.getProductApi().getProductBySku(productSkuId);
    }
}
