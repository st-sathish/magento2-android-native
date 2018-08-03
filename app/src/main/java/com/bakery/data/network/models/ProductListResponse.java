package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProductListResponse extends AbstractPagingResponse {

    @Expose
    @SerializedName("items")
    private List<ProductResponse> items = new ArrayList<>();

    public List<ProductResponse> getItems() {
        return items;
    }

    public void setItems(List<ProductResponse> items) {
        this.items = items;
    }
}
