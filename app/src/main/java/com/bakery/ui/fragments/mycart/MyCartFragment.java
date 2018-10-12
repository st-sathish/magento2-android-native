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
import android.widget.Toast;

import com.bakery.R;
import com.bakery.data.network.models.Address;
import com.bakery.data.network.models.CartListResponse;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.CartRequest2;
import com.bakery.data.network.models.CartResponse;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.decorators.ItemDecorationGridColumns;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.adapters.CartDetailListAdapter;
import com.bakery.ui.landingpage.LandingPageActivity;
import com.bakery.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyCartFragment extends BaseFragment implements MyCartMvpView, CartDetailListAdapter.OnCartProductListener {

    MyCartMvpPresenter<MyCartMvpView> mPresenter = new MyCartPresenter<>();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    CartDetailListAdapter cartDetailListAdapter = null;
    int currentPosition = -1;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;


    Address address = null;


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
    public void updateAddress(Address address) {
        this.address = address;
        LandingPageActivity activity = (LandingPageActivity)getActivity();
        if (activity != null && this.address != null) {
            activity.updateAddress(this.address);
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void update(CartListResponse cartListResponses) {
        cartDetailListAdapter.update(cartListResponses.getItems());
        LandingPageActivity activity = (LandingPageActivity)getActivity();
        if (activity != null && this.address != null) {
            activity.updateAddress(this.address);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mPresenter.getCartItems();
    }

    @OnClick(R.id.goto_address)
    public void onClick() {
        LandingPageActivity activity = (LandingPageActivity)getActivity();
        if(activity.getCount().equals("0") ){
            Toast.makeText(getActivity(), "There are no items in your cart. Add 1 or more items before continuing...", Toast.LENGTH_LONG).show();
        } else {
            switchFragment(LandingPageActivity.FRAGMENT_ADDRESS, "Billing Address", true);
        }
    }

    public void initializeRecyclerViewAdapter() {
        cartDetailListAdapter = new CartDetailListAdapter(getActivity(), R.layout.cart_details, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(cartDetailListAdapter);
        mRecyclerView.addItemDecoration(new ItemDecorationGridColumns(10, 2));
    }

    public void getProductCallback(ProductResponse productResponse) {
        //cartDetailListAdapter.refresh(productResponse);
    }

    @Override
    public void removedCartItem(View v, int position) {
        CartResponse response = cartDetailListAdapter.getItem(position);
        mPresenter.removeCart(response.getItemId());
        this.currentPosition = position;
/*
        cartDetailListAdapter.remove(position);
        LandingPageActivity activity = (LandingPageActivity)getActivity();
        if (activity != null) {
            activity.updateCartBadge(0 - response.getQty());
        }
*/
    }


    @Override
    public void removeCartCallback(Boolean success) {
        if (success) {
            CartResponse response = cartDetailListAdapter.getItem(currentPosition);
            LandingPageActivity activity = (LandingPageActivity)getActivity();
            if (activity != null) {
                activity.updateCartBadge(0 - response.getQty());
            }
            cartDetailListAdapter.remove(currentPosition);
            Toast.makeText(getActivity(), "Successfully Removed", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Failed to Remove. Try again later.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void updateCartItem(String quantity, int position) {
        CartResponse response = cartDetailListAdapter.getItem(position);
        Integer q = Integer.parseInt(quantity);
        CartRequest2.CartItem cartItem = new CartRequest2.CartItem(Integer.parseInt(response.getQuoteId()),  response.getItemId(), q);
        CartRequest2 request = new CartRequest2(cartItem);
        mPresenter.updateItemToCart(request, response.getItemId().toString());

    }
}
