package com.bakery.ui.fragments.drawer;

import com.androidnetworking.error.ANError;
import com.bakery.R;
import com.bakery.data.network.ApiEndpoints;
import com.bakery.data.network.models.CategoryResponse;
import com.bakery.data.ui.NavListItem;
import com.bakery.data.ui.models.CategoryItem;
import com.bakery.data.ui.models.GeneralItem;
import com.bakery.data.ui.models.NavItem;
import com.bakery.presenter.BasePresenter;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FragmentDrawerPresenter<V extends FragmentDrawerMvpView> extends BasePresenter<V> implements FragmentDrawerMvpPresenter<V> {

    private String[] accounts;

    private String[] services;

    private String[] offers;

    public FragmentDrawerPresenter(String[] offers, String[] accounts, String[] services) {
        this.accounts = accounts;
        this.services = services;
        this.offers = offers;
    }

    @Override
    public void fetchCategories() {
        final List<NavListItem> categoryItems = new ArrayList<>();
        final List<NavListItem> offerItems = new ArrayList<>();
        final List<NavListItem> accountItems = new ArrayList<>();
        final List<NavListItem> serviceItems = new ArrayList<>();

        Rx2AndroidNetworking
                .get(ApiEndpoints.API_GET_CATEGORIES)
                .addHeaders("Content-Type", "application/json")
                .build()
                .getObjectObservable(CategoryResponse.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryResponse categoryResponse) {
                        // add categories
                        addCategoryItem(categoryItems, categoryResponse.getChildrenData());
                        // add offer items
                        addOfferItems(offerItems);
                        // add my account items
                        addAccountsItems(accountItems);
                        // add terms and conditions items
                        addServiceItems(serviceItems);
                        getMvpView().setNavMenuItem(categoryItems, offerItems, accountItems, serviceItems);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached() && e instanceof ANError) {
                            ANError anError = (ANError) e;
                            handleApiError(anError);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void addCategoryItem(List<NavListItem> listItems, List<CategoryResponse> categoryResponses) {
        for(CategoryResponse cr: categoryResponses) {
            CategoryItem categoryItem = new CategoryItem();
            categoryItem.setCategoryResponse(cr);
            listItems.add(categoryItem);
        }
    }

    private void addOfferItems(List<NavListItem> listItems) {
        //offers 2
        Integer icons2[] = {R.mipmap.offer_icon,R.mipmap.notification};
        addMenuItem(listItems, icons2, offers);
    }

    private void addAccountsItems(List<NavListItem> listItems) {
        //accounts 3
        Integer icons3[] = {R.mipmap.cart,R.mipmap.wishlist_icon,R.mipmap.my_order_icon
                ,R.mipmap.account_icon, R.mipmap.categories_icon};
        addMenuItem(listItems, icons3, accounts);
    }

    private void addServiceItems(List<NavListItem> listItems) {
        //services 4
        Integer icons4[] = {R.mipmap.gift_icon,R.mipmap.store_icon,R.mipmap.help_center_icon
                ,R.mipmap.term_of_service_icon};
        addMenuItem(listItems, icons4, services);
    }

    private void addMenuItem(List<NavListItem> listItems, Integer icons[], String[] objs) {
        for (int i = 0; i < icons.length; i++) {
            GeneralItem generalItem = new GeneralItem();
            generalItem.setNavItem(new NavItem(objs[i], icons[i]));
            listItems.add(generalItem);
        }
    }
}
