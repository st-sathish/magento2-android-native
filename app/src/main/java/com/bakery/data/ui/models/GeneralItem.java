package com.bakery.data.ui.models;

import com.bakery.data.ui.NavListItem;

public class GeneralItem extends NavListItem {

    private NavItem navItem;

    public NavItem getNavItem() {
        return this.navItem;
    }

    public void setNavItem(NavItem navItem) {
        this.navItem = navItem;
    }

    @Override
    public int getType() {
        return TYPE_GENERAL;
    }
}
