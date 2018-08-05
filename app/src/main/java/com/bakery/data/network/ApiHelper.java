package com.bakery.data.network;

import com.bakery.data.network.product.ProductApi;
import com.bakery.data.network.security.SecurityApi;

public interface ApiHelper {

    SecurityApi getSecurityApi();

    ProductApi getProductApi();
}
