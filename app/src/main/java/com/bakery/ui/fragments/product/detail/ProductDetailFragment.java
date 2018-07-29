package com.bakery.ui.fragments.product.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bakery.R;
import com.bakery.presenter.MvpPresenter;
import com.bakery.ui.BaseFragment;
import com.bakery.utils.AppConstants;

import butterknife.ButterKnife;

public class ProductDetailFragment extends BaseFragment {


    public ProductDetailFragment() {

    }

    public static ProductDetailFragment newInstance(String title) {
        ProductDetailFragment productDetailFragment = new ProductDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        productDetailFragment.setArguments(bundle);
        return productDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_product, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        return view;
    }
}
