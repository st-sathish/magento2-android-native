package com.bakery.data;

import com.bakery.data.network.models.CategoryResponse;

import java.util.List;

public final class SessionStore {

    public static List<CategoryResponse> sSelectedExpandableCategory = null;

    public static CategoryResponse sSelectedCategory = null;

    private SessionStore() {

    }
}
