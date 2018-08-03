package com.bakery.ui.fragments.product.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.ui.BaseFragment;
import com.bakery.utils.AppConstants;
import com.bakery.utils.ComponentUtils;
import com.bakery.utils.ProductImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailFragment extends BaseFragment {

    @BindView(R.id.product_img_large)
    ImageView imageView;

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
        setUnBinder(ButterKnife.bind(this, view));
        init();
        return view;
    }

    public void init() {
        ProductResponse productDetail = SessionStore.productDetail;
        ProductImageUtils.loadGalleryImage(getContext(), imageView, productDetail.getMediaGalleryEntries());
    }

    @OnClick(R.id.my_cart_btn)
    public void onAddToCartClick() {

    }

    @OnClick(R.id.wish_btn)
    public void onAddToWishList() {

    }
}
