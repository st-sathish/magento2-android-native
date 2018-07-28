package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ApiProductDetail {

    @Expose
    @SerializedName("id")
    private Integer id;

    @Expose
    @SerializedName("sku")
    private String sku;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("attribute_set_id")
    private String attributeSetId;

    @Expose
    @SerializedName("price")
    private Double price;

    @Expose
    @SerializedName("status")
    private Integer status;

    @Expose
    @SerializedName("visibility")
    private Integer visibility;

    @Expose
    @SerializedName("type_id")
    private String typeId;

    @Expose
    @SerializedName("created_at")
    private String createdAt;

    @Expose
    @SerializedName("updated_at")
    private String updatedAt;

    @Expose
    @SerializedName("extension_attributes")
    private List<ApiExtensionAttribute> extensionAttributes;

    @Expose
    @SerializedName("product_links")
    private List<ApiProductLink> productLinks;

    @Expose
    @SerializedName("media_gallery_entries")
    private List<ApiMediaGalleryEntry> mediaGalleryEntries= new ArrayList<>();

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

    public List<ApiExtensionAttribute> getExtensionAttributes() {
        return extensionAttributes;
    }

    public void setExtensionAttributes(List<ApiExtensionAttribute> extensionAttributes) {
        this.extensionAttributes = extensionAttributes;
    }

    public List<ApiProductLink> getProductLinks() {
        return productLinks;
    }

    public void setProductLinks(List<ApiProductLink> productLinks) {
        this.productLinks = productLinks;
    }

    public List<ApiMediaGalleryEntry> getMediaGalleryEntries() {
        return mediaGalleryEntries;
    }

    public void setMediaGalleryEntries(List<ApiMediaGalleryEntry> mediaGalleryEntries) {
        this.mediaGalleryEntries = mediaGalleryEntries;
    }
}
