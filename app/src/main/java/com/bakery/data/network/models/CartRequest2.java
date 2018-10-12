package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartRequest2 {

    public CartRequest2(CartItem cartItem) {
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

        public CartItem(Integer quoteId, Integer itemId, Integer qty) {
            this.qty = qty;
            this.quoteId = quoteId;
            this.itemId = itemId;
        }

        @Expose
        @SerializedName("quote_id")
        private Integer quoteId;

        @Expose
        @SerializedName("item_id")
        private Integer itemId;

        @Expose
        @SerializedName("qty")
        private Integer qty;

        public Integer getQuoteId() {
            return quoteId;
        }

        public void setQuoteId(Integer quoteId) {
            this.quoteId = quoteId;
        }

        public Integer getItemId() {
            return itemId;
        }

        public void setItemId(Integer itemId) {
            this.itemId = itemId;
        }

        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
        }
    }
}
