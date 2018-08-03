package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse {

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
    private List<ExtensionAttribute> extensionAttributes;

    @Expose
    @SerializedName("product_links")
    private List<ProductLink> productLinks;

    @Expose
    @SerializedName("media_gallery_entries")
    private List<MediaGalleryEntry> mediaGalleryEntries= new ArrayList<>();

    @Expose
    @SerializedName("custom_attributes")
    private List<CustomAttribute> customAttributes = new ArrayList<>();

    public List<CustomAttribute> getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(List<CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
    }

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

    public List<MediaGalleryEntry> getMediaGalleryEntries() {
        return mediaGalleryEntries;
    }

    public void setMediaGalleryEntries(List<MediaGalleryEntry> mediaGalleryEntries) {
        this.mediaGalleryEntries = mediaGalleryEntries;
    }

    public static class MediaGalleryEntry {

        @Expose
        @SerializedName("id")
        private Integer id;

        @Expose
        @SerializedName("media_type")
        private String mediaType;

        @Expose
        @SerializedName("label")
        private String label;

        @Expose
        @SerializedName("position")
        private Integer position;

        @Expose
        @SerializedName("disabled")
        private boolean isDisabled;

        @Expose
        @SerializedName("types")
        private List<String> types = new ArrayList<>();

        @Expose
        @SerializedName("file")
        private  String file;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        public boolean isDisabled() {
            return isDisabled;
        }

        public void setDisabled(boolean isDisabled) {
            this.isDisabled = isDisabled;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }
    }

    public static class CustomAttribute {

        @Expose
        @SerializedName("attribute_code")
        private String attributeCode;

        @Expose
        @SerializedName("value")
        private String value;

        public String getAttributeCode() {
            return attributeCode;
        }

        public void setAttributeCode(String attributeCode) {
            this.attributeCode = attributeCode;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class ExtensionAttribute {
    }

    public static class ProductLink {

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
}
