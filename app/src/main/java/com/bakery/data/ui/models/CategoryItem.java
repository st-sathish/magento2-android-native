package com.bakery.data.ui.models;

import com.bakery.data.network.models.CategoryResponse;
import com.bakery.data.ui.NavListItem;

public class CategoryItem extends NavListItem {

    private CategoryResponse categoryResponse;

    public CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }

    public void setCategoryResponse(CategoryResponse categoryResponse) {
        this.categoryResponse = categoryResponse;
    }

    @Override
    public int getType() {
        return TYPE_CATEGORY;
    }
}
