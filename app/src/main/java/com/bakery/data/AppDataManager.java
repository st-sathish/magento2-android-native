package com.bakery.data;

import com.bakery.data.db.domain.Cart;
import com.bakery.data.network.ApiHelper;
import com.bakery.data.network.AppApiHelper;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.ProductListResponse;
import com.bakery.data.network.models.ProductResponse;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;

public class AppDataManager implements DataManager {

    private ApiHelper mApiHelper;

    public AppDataManager() {
        mApiHelper = new AppApiHelper();
    }

    @Override
    public Observable<JSONObject> signUp(JSONObject body) {
        return this.mApiHelper.getSecurityApi().signUp(body);
    }

    @Override
    public Observable<String> login(Map<String, String> body) {
        return this.mApiHelper.getSecurityApi().login(body);
    }

    @Override
    public Observable<ProductListResponse> getProductDetailListByCategoryId(int currentPage, int pageSize, int categoryId) {
        return this.mApiHelper.getProductApi().getProductDetailListByCategoryId(currentPage, pageSize, categoryId);
    }

    @Override
    public Observable<ProductResponse> getProductBySku(String productSkuId) {
        return this.mApiHelper.getProductApi().getProductBySku(productSkuId);
    }

    @Override
    public Observable<Cart> addToCartApi(CartRequest cartRequest) {
        return this.mApiHelper.getProductApi().addCartApi(cartRequest);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public String getAccessToken() {
        return null;
    }
}
