package com.bakery.data.network;

import com.bakery.BuildConfig;

public final class ApiEndpoints {

    private ApiEndpoints() {

    }

    private static final String API_URL = BuildConfig.BASE_URL + "/rest/V1";

    /** Custom login API */
    public static final String LOGIN_API = API_URL + "/integration/customer/token";

    /** Reset Password API */
    public static final String RESET_PWD_API = API_URL + "/customers/password";

    /** Get all categories */
    public static final String API_GET_CATEGORIES = API_URL + "/categories";

    /** Customer sign up post request */
    public static final String API_POST_CUSTOMER_SIGNUP = API_URL + "/customers";

    /** Get all categories */
    public static final String API_GET_PRODUCTS = API_URL + "/products";

    /** Add product to the cart */
    public static final String API_POST_ADD_CART = API_URL + "/carts/mine/items";

    /** get and post cart items */
    public static final String API_GET_AND_CREATE_EMPTY_CART = API_URL +"/carts/mine";

    /** Delete cart item */
    public static final String API_DELETE_CART_ITEM = API_URL +"/carts/mine/items/{itemId}";

    /** Set shipping and billing information */
    public static final String API_SET_BILLING_SHIPPING_ADDRESS = API_URL + "/carts/mine/shipping-information";

    /** Place Order */
    public static final String API_PLACE_ORDER = API_URL +"/carts/mine/payment-information";

    public static final String HEADER_AUTHORIZATION = "Authorization";
}
