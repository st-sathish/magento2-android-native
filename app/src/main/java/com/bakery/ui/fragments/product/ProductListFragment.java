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
import android.widget.ProgressBar;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.decorators.ItemDecorationGridColumns;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.adapters.ProductListAdapter;
import com.bakery.ui.landingpage.LandingPageActivity;
import com.bakery.ui.listeners.EndlessRecyclerOnScrollListener;
import com.bakery.ui.listeners.OnItemClickListener;
import com.bakery.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListFragment extends BaseFragment implements ProductListMvp, OnItemClickListener {

    ProductListMvpPresenter<ProductListMvp> mPresenter = new ProductListPresenter<>();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    ProductListAdapter productListAdapter = null;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public ProductListFragment() {

    }

    public static ProductListFragment newInstance(String title) {
        ProductListFragment productListFragment = new ProductListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        productListFragment.setArguments(bundle);
        return productListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_product_list, container, false);
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
    public void update(List<ProductResponse> productResponses) {
        productListAdapter.update(productResponses);
    }

    public void initializeRecyclerViewAdapter() {
        productListAdapter = new ProductListAdapter(getActivity(), this, R.layout.item_product_list);
        //mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(productListAdapter);
       // mRecyclerView.addItemDecoration(new ItemDecorationGridColumns(10, 2));
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
        SessionStore.productDetail = productListAdapter.getItem(position);
        switchFragment(LandingPageActivity.FRAGMENT_DETAILS_PRODUCT, "", true);
    }

    @Override
    public void showEndlessSpinner() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEndlessSpinner() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
