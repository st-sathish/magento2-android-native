package com.bakery.Bean;

/**
 * Created by system2 on 13-Feb-18.
 */

public class CategoryBean {
    int id;
    String image;
    String name;
    String price;
    String sku;
    String cate_id;
    int position;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public void setPosition(int position) {
        this.position = position;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
