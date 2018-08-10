package com.bakery.utils;

import android.widget.TextView;

public final class ProductUtils {

    private ProductUtils() {
        // avoid to create an instance outside
    }

    public static String increaseItemQuantity(String quantity) {
        int qty = Integer.valueOf(quantity);
        if(qty < 1) {
            return "1";
        }
        qty += 1;
        return String.valueOf(qty);
    }

    public static String deceaseItemQuantity(String quantity) {
        int qty = Integer.valueOf(quantity);
        if(qty <= 1) {
            return "1";
        }
        qty -= 1;
        return String.valueOf(qty);
    }
}
