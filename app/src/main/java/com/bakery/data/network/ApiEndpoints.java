package com.bakery.data.network;

import com.bakery.BuildConfig;

public final class ApiEndpoints {

    private ApiEndpoints() {

    }

    public static final String LOGIN_API = BuildConfig.BASE_URL + "/integration/customer/token";
}
