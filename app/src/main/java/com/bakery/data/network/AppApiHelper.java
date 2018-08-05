package com.bakery.data.network;

import com.bakery.data.network.product.ProductApi;
import com.bakery.data.network.product.ProductApiImpl;
import com.bakery.data.network.security.SecurityApi;
import com.bakery.data.network.security.SecurityApiImpl;

public class AppApiHelper implements ApiHelper {

    private ProductApi productApi;

    private SecurityApi securityApi;

    private AppApiHeader mAppApiHeader;

    public AppApiHelper() {
        // manage all api helpers
        productApi = new ProductApiImpl();
        securityApi = new SecurityApiImpl();
        mAppApiHeader = new AppApiHeader();
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
    public ProductApi getProductApi() {
        return this.productApi;
    }
}
