package com.bakery.data.db.domain;


public class ProductLink {

    private String sku;

    private String linkType;

    private String linkedProductSku;

    private String linkedProductType;

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
