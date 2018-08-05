package com.bakery.data.db.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cart {

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
