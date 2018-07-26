package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiProductLink {

    @Expose
    @SerializedName("sku")
    private String sku;

    @Expose
    @SerializedName("link_type")
    private String linkType;

    @Expose
    @SerializedName("linked_product_sku")
    private String linkedProductSku;

    @Expose
    @SerializedName("linked_product_type")
    private String linkedProductType;

    @Expose
    @SerializedName("position")
    private Integer position;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkedProductSku() {
        return linkedProductSku;
    }

    public void setLinkedProductSku(String linkedProductSku) {
        this.linkedProductSku = linkedProductSku;
    }

    public String getLinkedProductType() {
        return linkedProductType;
    }

    public void setLinkedProductType(String linkedProductType) {
        this.linkedProductType = linkedProductType;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
