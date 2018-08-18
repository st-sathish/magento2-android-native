package com.bakery.utils;

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

    public static String decreaseCartBadge(String count) {
        if(count != null && !count.equals("")) {
            Integer c = Integer.parseInt(count);
            return (c - 1 + "");
        }
        return "0";
    }

    public static String increaseCartBadge(String count) {
        if(count != null && !count.equals("")) {
            Integer c = Integer.parseInt(count);
            return (c - 1 + "");
        }
        return "0";
    }

    public static String increaseCartBadge(String count, String quantity) {
        if(count != null && !count.equals("")) {
            Integer c = Integer.parseInt(count);
            return (c + Integer.valueOf(quantity) + "");
        }
        return "0";
    }
}
