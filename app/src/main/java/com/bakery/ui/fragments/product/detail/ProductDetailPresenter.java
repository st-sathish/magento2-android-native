package com.bakery.ui.fragments.product.detail;

import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.BasePresenter;

public class ProductDetailPresenter <V extends ProductDetailMvp> extends BasePresenter<V> implements ProductDetailMvpPresenter<V> {

    @Override
    public void setViewValue(ProductResponse mProductDetail) {
        if(!isViewAttached()) {
            return;
        }
        getMvpView().setProductName(mProductDetail.getName());
        getMvpView().setProductPrice(String.valueOf(mProductDetail.getPrice()));
        for(ProductResponse.CustomAttribute customAttribute: mProductDetail.getCustomAttributes()) {
            if(customAttribute.getAttributeCode().equals("description")) {
                getMvpView().setDescription(customAttribute.getValue());
            }
            if(customAttribute.getAttributeCode().equals("short_description")) {
                getMvpView().setShortDescription(customAttribute.getValue());
            }
        }
    }
}
