package com.bakery.data.db.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CartList {

    @Expose
    @SerializedName("id")
    private Integer id;

    @Expose
    @SerializedName("created_at")
    private String createdAt;

    @Expose
    @SerializedName("updated_at")
    private String updatedAt;

    @Expose
    @SerializedName("is_active")
    private Boolean isActive = false;

    @Expose
    @SerializedName("is_virtual")
    private Boolean isVirtual = false;

    @Expose
    @SerializedName("items")
    private List<Cart> items = new ArrayList<>();

    @Expose
    @SerializedName("items_count")
    private Integer itemsCount = 0;

    @Expose
    @SerializedName("items_qty")
    private Integer itemsQty = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getVirtual() {
        return isVirtual;
    }

    public void setVirtual(Boolean virtual) {
        isVirtual = virtual;
    }

    public List<Cart> getItems() {
        return items;
    }

    public void setItems(List<Cart> items) {
        this.items = items;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public Integer getItemsQty() {
        return itemsQty;
    }

    public void setItemsQty(Integer itemsQty) {
        this.itemsQty = itemsQty;
    }
}
