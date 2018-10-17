package com.bakery.ui.fragments.address;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bakery.R;
import com.bakery.ui.BaseFragment;
import com.bakery.utils.AppConstants;

import butterknife.ButterKnife;

public class ShippingAddressFragment extends BaseFragment {

    public static ShippingAddressFragment newInstance(String title) {
        ShippingAddressFragment addressFragment = new ShippingAddressFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        addressFragment.setArguments(bundle);
        return addressFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_shipping_address, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
