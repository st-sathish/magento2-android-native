package com.bakery.data.network;

import com.bakery.data.network.cart.CartApi;
import com.bakery.data.network.cart.CartApiImpl;
import com.bakery.data.network.order.OrderApi;
import com.bakery.data.network.order.OrderApiImpl;
import com.bakery.data.network.product.ProductApi;
import com.bakery.data.network.product.ProductApiImpl;
import com.bakery.data.network.security.SecurityApi;
import com.bakery.data.network.security.SecurityApiImpl;

public class AppApiHelper implements ApiHelper {

    private ProductApi productApi;

    private SecurityApi securityApi;

    private AppApiHeader mAppApiHeader;

    private CartApi mCartApi;

    private OrderApi orderApi;

    public AppApiHelper() {
        // manage all api helpers
        productApi = new ProductApiImpl();
        securityApi = new SecurityApiImpl();
        mAppApiHeader = new AppApiHeader();
        mCartApi = new CartApiImpl();
        orderApi = new OrderApiImpl();
    }

    @Override
    public SecurityApi getSecurityApi() {
        return this.securityApi;
    }

    @Override
    public AppApiHeader getApiHeader() {
        return mAppApiHeader;
    }

    @Override
    public CartApi getCartApi() {
        return this.mCartApi;
    }

    @Override
    public ProductApi getProductApi() {
        return this.productApi;
    }

    @Override
    public OrderApi getOrderApi() { return this.orderApi; }
}
