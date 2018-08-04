package com.bakery.ui.fragments.product.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.ui.BaseFragment;
import com.bakery.utils.AppConstants;
import com.bakery.utils.ProductImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailFragment extends BaseFragment implements ProductDetailMvp {

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
        return view;
    }

    @OnClick(R.id.my_cart_btn)
    public void onAddToCartClick() {

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
    public void onDestroy() {
        mvpPresenter.onDetach();
        super.onDestroy();
    }
}
