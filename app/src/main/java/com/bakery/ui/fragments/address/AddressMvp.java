package com.bakery.ui.fragments.address;

import com.bakery.presenter.MvpView;

public interface AddressMvp extends MvpView {

    void addressCallback();

    void orderCallback();

}
