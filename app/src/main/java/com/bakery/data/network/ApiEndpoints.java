package com.bakery.data.network;

import com.bakery.BuildConfig;

public final class ApiEndpoints {

    private ApiEndpoints() {

    }

    /** Custom login API */
    public static final String LOGIN_API = BuildConfig.BASE_URL + "/integration/customer/token";

    /** Get all categories */
    public static final String API_GET_CATEGORIES = BuildConfig.BASE_URL + "/categories";

    /** Customer signup post request */
    public static final String API_POST_CUSTOMER_SIGNUP = BuildConfig.BASE_URL + "/customers";
}
