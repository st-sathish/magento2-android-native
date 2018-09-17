package com.bakery.ui.fragments.address;

import com.bakery.data.network.models.AddressModel;
import com.bakery.data.network.models.OrderRequest;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.presenter.MvpPresenter;
import com.bakery.presenter.MvpView;

import java.util.List;

public interface AddressMvpPresenter<V extends MvpView> extends MvpPresenter<V> {

    void placeOrder(OrderRequest order);

    void setAddress(AddressModel address);
}
