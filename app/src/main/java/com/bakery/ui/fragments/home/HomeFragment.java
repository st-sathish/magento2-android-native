package com.bakery.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bakery.R;
import com.bakery.ui.BaseFragment;
import com.bakery.utils.AppConstants;

public class HomeFragment extends BaseFragment {

    public HomeFragment() {

    }

    public static HomeFragment newInstance(String title) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_home, container, false);
    }
}
