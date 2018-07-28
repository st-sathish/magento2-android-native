package com.bakery.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ApiMediaGalleryEntry {

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
