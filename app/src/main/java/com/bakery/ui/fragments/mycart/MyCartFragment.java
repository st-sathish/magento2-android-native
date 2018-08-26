package com.bakery.ui.fragments.mycart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bakery.R;
import com.bakery.ui.BaseFragment;
import com.bakery.utils.AppConstants;

public class MyCartFragment extends BaseFragment implements MyCartMvpView {

    public MyCartFragment() {

    }

    public static MyCartFragment newInstance(String title) {
        MyCartFragment myCartFragment = new MyCartFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        myCartFragment.setArguments(bundle);
        return myCartFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_my_cart, container, false);
    }
}
