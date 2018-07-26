package com.bakery.data.db.models;

import java.util.List;

public class ProductDetail {

    private Integer id;

    private String sku;

    private String name;

    private String attributeSetId;

    private Double price;

    private Integer status;

    private Integer visibility;

    private String typeId;

    private String createdAt;

    private String updatedAt;

    private List<ExtensionAttribute> extensionAttributes;

    private List<ProductLink> productLinks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributeSetId() {
        return attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId) {
        this.attributeSetId = attributeSetId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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

    public List<ExtensionAttribute> getExtensionAttributes() {
        return extensionAttributes;
    }

    public void setExtensionAttributes(List<ExtensionAttribute> extensionAttributes) {
        this.extensionAttributes = extensionAttributes;
    }

    public List<ProductLink> getProductLinks() {
        return productLinks;
    }

    public void setProductLinks(List<ProductLink> productLinks) {
        this.productLinks = productLinks;
    }
}
