package com.bakery.ui.fragments.cart;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.CartResponse;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.adapters.CartProductListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartFragment extends BaseFragment implements CartMvpView, CartProductListAdapter.OnCartProductListener {

    CartMvpPresenter<CartMvpView> mPresenter;

    @BindView(R.id.cart_recycler_view)
    RecyclerView mCartRecyclerView;

    @BindView(R.id.item_count1)
    TextView mBadgeCount;

    CartProductListAdapter mCartProducts = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_cart, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter = new CartPresenter<>();
        mPresenter.onAttach(this);
        initializeCartRecyclerView();
        mPresenter.getCartItems();
        return view;
    }

    @Override
    public void removedCartItem(View v, int position) {
        ProductResponse response = mCartProducts.getItem(position);
        mPresenter.removeCart(response.getId());
        mCartProducts.remove(position);
    }

    public void addToCart(ProductResponse response, String quantity) {
        Integer q = Integer.parseInt(quantity);
        CartRequest.CartItem cartItem = new CartRequest.CartItem(SessionStore.quoteId, response.getSku(), q);
        CartRequest request = new CartRequest(cartItem);
        mPresenter.addCart(request);
    }

    public void initializeCartRecyclerView() {
        mCartProducts = new CartProductListAdapter(getActivity(), this);
        mCartRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        mCartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mCartRecyclerView.setAdapter(mCartProducts);
    }

    @Override
    public void removeCartCallback(Boolean b) {
        Toast.makeText(getActivity(), "Successfully Removed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void getProductCallback(ProductResponse productResponse) {
        mCartProducts.refresh(productResponse);
    }

    @Override
    public void updateBadge(Integer qty) {
        Integer count = Integer.parseInt(mBadgeCount.getText().toString());
        mBadgeCount.setText((count > 0)
                ? String.valueOf(count + qty)
                : String.valueOf(qty));
    }

    @Override
    public void addCartCallback(CartResponse cartResponse) {
        updateBadge(cartResponse.getQty());
        mPresenter.getProductsBySku(cartResponse.getSku());
    }

    @Override
    public void getCartProductsCallback(List<ProductResponse> productResponses) {
        mCartProducts.refreshAll(productResponses);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }
}
