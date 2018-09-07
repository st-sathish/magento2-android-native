package com.bakery.ui.fragments.mycart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bakery.R;
import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.decorators.ItemDecorationGridColumns;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.adapters.CartDetailListAdapter;
import com.bakery.ui.adapters.CartProductListAdapter;
import com.bakery.ui.landingpage.LandingPageActivity;
import com.bakery.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCartFragment extends BaseFragment implements MyCartMvpView {

    MyCartMvpPresenter<MyCartMvpView> mPresenter = new MyCartPresenter<>();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    CartDetailListAdapter cartDetailListAdapter = null;

    CartProductListAdapter mCartProducts = null;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    
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
        View view =  inflater.inflate(R.layout.fr_my_cart, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        initializeRecyclerViewAdapter();
        mPresenter.getCartItems();
        return view;
        
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void update(CartListResponse cartListResponses) {
        cartDetailListAdapter.update(cartListResponses.getItems());
        LandingPageActivity activity = (LandingPageActivity)getActivity();
        if (activity != null) {
            activity.updateCartBadge(cartListResponses.getItemsQty());
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mPresenter.getCartItems();
    }

    public void initializeRecyclerViewAdapter() {
        cartDetailListAdapter = new CartDetailListAdapter(getActivity(), R.layout.cart_details);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(cartDetailListAdapter);
        mRecyclerView.addItemDecoration(new ItemDecorationGridColumns(10, 2));
    }

    public void getProductCallback(ProductResponse productResponse) {
        mCartProducts.refresh(productResponse);
    }

}
