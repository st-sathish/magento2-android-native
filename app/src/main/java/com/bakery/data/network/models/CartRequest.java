package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartRequest {

    public CartRequest(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    @Expose
    @SerializedName("cart_item")
    private CartItem cartItem;

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public static class CartItem {

        public CartItem(Integer quoteId, String sku, Integer qty) {
            this.qty = qty;
            this.quoteId = quoteId;
            this.sku = sku;
        }

        @Expose
        @SerializedName("quote_id")
        private Integer quoteId;

        @Expose
        @SerializedName("sku")
        private String sku;

        @Expose
        @SerializedName("qty")
        private Integer qty;

        public Integer getQuoteId() {
            return quoteId;
        }

        public void setQuoteId(Integer quoteId) {
            this.quoteId = quoteId;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
        }
    }
}
