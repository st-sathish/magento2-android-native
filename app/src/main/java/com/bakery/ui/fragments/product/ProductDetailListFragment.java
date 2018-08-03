package com.bakery.ui.fragments.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.ApiProductDetail;
import com.bakery.decorators.ItemDecorationGridColumns;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.adapters.ProductDetailListAdapter;
import com.bakery.ui.landingpage.LandingPageActivity;
import com.bakery.ui.listeners.EndlessRecyclerOnScrollListener;
import com.bakery.ui.listeners.OnItemClickListener;
import com.bakery.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailListFragment extends BaseFragment implements ProductDetailListMvp, OnItemClickListener {

    ProductDetailListMvpPresenter<ProductDetailListMvp> mPresenter = new ProductDetailListPresenter<>();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    ProductDetailListAdapter productDetailListAdapter = null;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public ProductDetailListFragment() {

    }

    public static ProductDetailListFragment newInstance(String title) {
        ProductDetailListFragment productDetailListFragment = new ProductDetailListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        productDetailListFragment.setArguments(bundle);
        return productDetailListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_product_detail_list, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        initializeRecyclerViewAdapter();
        return view;
    }

    @Override
    public void stopEndlessLoading() {
        loadMoreRecord = false;
        progressBar.setVisibility(View.INVISIBLE);
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
        productDetailListAdapter = new ProductDetailListAdapter(getActivity(), this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(productDetailListAdapter);
        mRecyclerView.addItemDecoration(new ItemDecorationGridColumns(10, 2));
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                if(loadMoreRecord) {
                    mPresenter.loadNextPage();
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onItemClick(View v, int position) {
        SessionStore.productDetail = productDetailListAdapter.getItem(position);
        switchFragment(LandingPageActivity.FRAGMENT_DETAILS_PRODUCT, "", true);
    }
}
