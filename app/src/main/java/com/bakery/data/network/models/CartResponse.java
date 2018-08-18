package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartResponse {

    @Expose
    @SerializedName("item_id")
    private Integer itemId;

    @Expose
    @SerializedName("sku")
    private String sku;

    @Expose
    @SerializedName("qty")
    private Integer qty;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("price")
    private Integer price;

    @Expose
    @SerializedName("quote_id")
    private String quoteId;

    @Expose
    @SerializedName("product_type")
    private String productType;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
