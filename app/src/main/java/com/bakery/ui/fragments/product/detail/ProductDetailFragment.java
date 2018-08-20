package com.bakery.ui.fragments.product.detail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.adapters.RelatedProductListAdapter;
import com.bakery.ui.listeners.OnRelatedProductClickListener;
import com.bakery.utils.AppConstants;
import com.bakery.utils.ProductImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailFragment extends BaseFragment implements ProductDetailMvp, OnRelatedProductClickListener {

    @BindView(R.id.product_img_large)
    ImageView imageView;

    @BindView(R.id.product_name)
    TextView tvProductName;

    @BindView(R.id.price)
    TextView tvProductPrice;

    @BindView(R.id.short_description)
    TextView tvShortDescription;

    @BindView(R.id.description)
    TextView tvDescription;

    ProductResponse mProductDetail;

    ProductDetailMvpPresenter<ProductDetailMvp> mvpPresenter;

    @BindView(R.id.recycler_view)
    RecyclerView mRelatedProductRecyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.item_quantity)
    TextView quantity;

    RelatedProductListAdapter productListAdapter = null;

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
        View view = inflater.inflate(R.layout.fr_product_detail, container, false);
        mvpPresenter = new ProductDetailPresenter<>();
        setUnBinder(ButterKnife.bind(this, view));
        mvpPresenter.onAttach(this);
        mProductDetail = SessionStore.productDetail;
        mvpPresenter.setViewValue(mProductDetail);
        ProductImageUtils.loadAttributeImage(getActivity(), imageView, mProductDetail.getCustomAttributes());
        initializeRecyclerViewAdapter();
        return view;
    }

    @OnClick(R.id.add_item)
    public void addItemQuantity() {
        mvpPresenter.increaseQuantity(quantity.getText().toString());
    }

    @OnClick(R.id.remove_item)
    public void removeItemQuantity() {
        mvpPresenter.decreaseQuantity(quantity.getText().toString());
    }

    @OnClick(R.id.my_cart_btn)
    public void onAddToCartClick() {
        addToCart(mProductDetail, quantity.getText().toString());
/*
        mvpPresenter.addCart(quantity.getText().toString(), SessionStore.productDetail.getSku());
        updateCartCount(quantity.getText().toString());
*/
    }

    @Override
    public void setProductName(String productName) {
        tvProductName.setText(productName);
    }

    @Override
    public void setProductPrice(String productPrice) {
        String price = getString(R.string.Rs)+" "+productPrice;
        tvProductPrice.setText(price);
    }

    @OnClick(R.id.wish_btn)
    public void onAddToWishList() {

    }

    @Override
    public void setDescription(String description) {
        tvDescription.setText(description);
    }

    @Override
    public void setShortDescription(String shortDescription) {
        tvShortDescription.setText(shortDescription);
    }

    @Override
    public void onRelatedProductsSuccess(List<ProductResponse> relatedProducts) {
        productListAdapter.update(relatedProducts);
    }

    public void initializeRecyclerViewAdapter() {
        productListAdapter = new RelatedProductListAdapter(getContext(), this);
        mRelatedProductRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRelatedProductRecyclerView.setAdapter(productListAdapter);
        /*mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                if(loadMoreRecord) {
                    mPresenter.loadNextPage();
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });*/
        // load related products
        mvpPresenter.getProductRelatedLinks(mProductDetail.getProductLinks());
    }

    @Override
    public void showHorizontalProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideHorizontalProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void updateQuantity(String q) {
        quantity.setText(q);
    }

    @Override
    public void switchProductListFragment(Integer addedCount) {
        doIncrementCartCount(addedCount);
        goBack();
    }

    @Override
    public void onDestroy() {
        mvpPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onProductClick(View v, int position) {

    }
}
