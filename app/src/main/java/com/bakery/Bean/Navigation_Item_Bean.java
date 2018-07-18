package com.bakery.Bean;

/**
 * Created by system2 on 22-Dec-17.
 */

public class Navigation_Item_Bean {
    String title, subtitle;
    Integer icon;

    public Navigation_Item_Bean(String title, Integer icon) {
        this.title = title;

        this.icon = icon;
    }
    public String getTitle() {
        return title;
    }
    public Integer getIcon() {
        return icon;
    }

}

