package com.bakery.data;

import com.bakery.data.db.domain.Cart;
import com.bakery.data.db.domain.CartOverview;
import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.CartResponse;
import com.bakery.data.network.models.ProductListResponse;
import com.bakery.data.network.models.ProductResponse;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;

public interface DataManager {

    Observable<JSONObject> signUp(JSONObject body);

    Observable<String> login(Map<String, String> body);

    Observable<ProductListResponse> getProductDetailListByCategoryId(int currentPage, int pageSize, int categoryId);

    Observable<ProductResponse> getProductBySku(String productSkuId);

    void setAccessToken(String accessToken);

    String getAccessToken();

    Observable<CartListResponse> getCartItems();

    Observable<CartResponse> addItemCart(CartRequest request);

    Observable<String> createEmptyCart();

    Observable<Boolean> deleteCartItem(String itemId);
}
