package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoryResponse {

    @Expose
    @SerializedName("id")
    private Integer id;

    @Expose
    @SerializedName("parent_id")
    private Integer parentId;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("is_active")
    private Boolean isActive;

    @Expose
    @SerializedName("position")
    private Integer position;

    @Expose
    @SerializedName("level")
    private Integer level;

    @Expose
    @SerializedName("product_count")
    private Integer productCount;

    private int icon;

    @Expose
    @SerializedName("children_data")
    private List<CategoryResponse> childrenData = new ArrayList<>();

    public CategoryResponse(int id, String name, int icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public List<CategoryResponse> getChildrenData() {
        return childrenData;
    }

    public void setChildrenData(List<CategoryResponse> childrenData) {
        this.childrenData = childrenData;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
