package com.bakery.ui.fragments.cartdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bakery.R;
import com.bakery.ui.BaseFragment;
import com.bakery.utils.AppConstants;

public class CartDetailsFragment extends BaseFragment implements CartDetailsMvpView {

    public CartDetailsFragment() {

    }

    public static CartDetailsFragment newInstance(String title) {
        CartDetailsFragment cartDetailsFragment = new CartDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        cartDetailsFragment.setArguments(bundle);
        return cartDetailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_cart_details, container, false);
    }
}
