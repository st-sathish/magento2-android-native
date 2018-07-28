package com.bakery.ui.fragments.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.ApiProductDetail;
import com.bakery.decorators.ItemDecorationGridColumns;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.adapters.ExpCategoryAdapter;
import com.bakery.ui.adapters.ProductDetailListAdapter;
import com.bakery.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductFragment extends BaseFragment implements ProductMvp {

    ProductMvpPresenter<ProductMvp> mPresenter = new ProductPresenter<>();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    ProductDetailListAdapter productDetailListAdapter = null;

    public ProductFragment() {

    }

    public static ProductFragment newInstance(String title) {
        ProductFragment productFragment = new ProductFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        productFragment.setArguments(bundle);
        return productFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_product, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        initializeRecyclerViewAdapter();
        return view;
    }

    @Override
    public void loadNextPage() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.pickProducts();
    }

    @Override
    public void update(List<ApiProductDetail> apiProductDetails) {
        productDetailListAdapter.update(apiProductDetails);
    }

    public void initializeRecyclerViewAdapter() {
        productDetailListAdapter = new ProductDetailListAdapter(getActivity());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(productDetailListAdapter);
        mRecyclerView.addItemDecoration(new ItemDecorationGridColumns(10, 2));
    }
}
