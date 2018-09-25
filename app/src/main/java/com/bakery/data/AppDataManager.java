package com.bakery.data;

import com.bakery.data.db.domain.Cart;
import com.bakery.data.db.domain.CartOverview;
import com.bakery.data.network.ApiHelper;
import com.bakery.data.network.AppApiHelper;
import com.bakery.data.network.models.AddressModel;
import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.CartResponse;
import com.bakery.data.network.models.OrderRequest;
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
    public Observable<CartListResponse> getCartItems() {
        return mApiHelper.getCartApi().getItems();
    }

    @Override
    public Observable<CartResponse> addItemCart(CartRequest request) {
        return mApiHelper.getCartApi().addItem(request);
    }

    @Override
    public Observable<CartResponse> updateItemCart(CartRequest request, String itemId) {
        return mApiHelper.getCartApi().updateItem(request, itemId);
    }

    @Override
    public Observable<String> createEmptyCart() {
        return mApiHelper.getCartApi().createEmpty();
    }

    @Override
    public Observable<Boolean> deleteCartItem(Integer itemId) {
        return mApiHelper.getCartApi().deleteItem(itemId);
    }

    @Override
    public Observable<String> placeOrder(OrderRequest order) {
        return mApiHelper.getOrderApi().placeOrder(order);
    }

    @Override
    public Observable<JSONObject> setAddress(AddressModel address) {
        return mApiHelper.getOrderApi().setAddress(address);
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
