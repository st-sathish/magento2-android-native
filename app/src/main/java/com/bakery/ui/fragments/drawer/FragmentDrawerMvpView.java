package com.bakery.ui.fragments.drawer;

import com.bakery.data.ui.NavListItem;
import com.bakery.presenter.MvpView;

import java.util.List;

public interface FragmentDrawerMvpView extends MvpView {

    void setNavMenuItem(List<NavListItem> categoryItems, List<NavListItem> offerItems,
                        List<NavListItem> accountItems, List<NavListItem> serviceItems);
}
