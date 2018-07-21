package com.bakery.data.ui;

public abstract class NavListItem {

    public static final int TYPE_CATEGORY = 0;
    public static final int TYPE_GENERAL = 1;

    abstract public int getType();
}
