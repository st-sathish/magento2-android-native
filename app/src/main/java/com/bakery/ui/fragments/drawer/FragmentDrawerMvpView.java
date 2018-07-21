package com.bakery.ui.fragments.drawer;

import com.bakery.data.network.models.CategoryResponse;
import com.bakery.presenter.MvpView;

import java.util.List;

public interface FragmentDrawerMvpView extends MvpView {

    void setNavMenuItem(List<CategoryResponse> categoryResponses);
}
