package com.bakery.ui.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bakery.R;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.utils.ProductImageUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartProductListAdapter extends RecyclerView.Adapter<CartProductListAdapter.CartProductViewHolder> {

    private List<ProductResponse> mProductDetails = new ArrayList<>();

    private Context mContext;

    private OnCartProductListener mOnCartProductListener;

    public CartProductListAdapter(Context context, OnCartProductListener mOnCartProductListener) {
        this.mContext = context;
        this.mOnCartProductListener = mOnCartProductListener;
    }

    public void refresh(ProductResponse productDetail) {
        mProductDetails.add(productDetail);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        mProductDetails.remove(position);
        notifyDataSetChanged();
    }

    public ProductResponse getItem(int position) {
        return mProductDetails.get(position);
    }

    @Override
    public CartProductListAdapter.CartProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_cart_product, parent, false);
        return new CartProductListAdapter.CartProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartProductListAdapter.CartProductViewHolder itemHolder, int position) {
        ProductResponse productDetail = mProductDetails.get(position);
        ProductImageUtils.loadImage(mContext, itemHolder.itemCartProductThumb, productDetail);
    }

    @Override
    public int getItemCount() {
        return mProductDetails != null ? mProductDetails.size() : 0;
    }

    public interface OnCartProductListener {
        void removedCartItem(View v, int position);
        ProductResponse getItem(int position);
    }

    class CartProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.item_cart_thumb)
        ImageView itemCartProductThumb;

        @BindView(R.id.item_remove_cart_product)
        ImageView itemRemoveCartProduct;

        public CartProductViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(this);
            itemRemoveCartProduct.setOnClickListener(this);
            v.setTag(this);
        }

        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.item_remove_cart_product:
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int choice) {
                            switch (choice) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    mOnCartProductListener.removedCartItem(v, getAdapterPosition());
                                    break;
                                case DialogInterface.BUTTON_NEGATIVE:
                                    dialog.cancel();
                                    break;
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                    builder.setMessage("Do you want to remove " + mOnCartProductListener.getItem(getAdapterPosition()).getName() + " from cart?")
                            .setPositiveButton("Yes", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener)
                            .setTitle("Ramvel Traders")
                            .show();
                    break;
                default:
                    break;
            }
        }
    }
}
