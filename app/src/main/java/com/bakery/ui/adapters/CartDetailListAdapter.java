package com.bakery.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.network.models.CartResponse;
import com.bakery.utils.ProductImageUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartDetailListAdapter extends RecyclerView.Adapter<CartDetailListAdapter.CartDetailViewHolder> {
    private List<CartResponse> mProductDetails = new ArrayList<>();

    private Context mContext;

    private int mLayout;

    private OnCartProductListener mOnCartProductListener;

    public CartDetailListAdapter(Context context, int layout, OnCartProductListener mOnCartProductListener) {
        mContext = context;
        this.mLayout = layout;
        this.mOnCartProductListener = mOnCartProductListener;
    }


    public CartResponse getItem(int position) {
        return mProductDetails.get(position);
    }

    @Override
    public CartDetailListAdapter.CartDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(mLayout, parent, false);
        return new CartDetailListAdapter.CartDetailViewHolder(view);
    }

    public void update(List<CartResponse> productDetails) {
        mProductDetails.addAll(productDetails);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(CartDetailListAdapter.CartDetailViewHolder itemHolder, int position) {
        CartResponse productDetail = mProductDetails.get(position);
        itemHolder.name.setText(productDetail.getName());
        String price = mContext.getResources().getString(R.string.Rs)+" " +String.valueOf(productDetail.getPrice());
        itemHolder.price.setText(price);
        itemHolder.quantity.setText(productDetail.getQty().toString());
        ProductImageUtils.loadImage(mContext, itemHolder.imageView, "dummy");
    }

    @Override
    public int getItemCount() {
        return mProductDetails != null ? mProductDetails.size() : 0;
    }

    public void remove(int position) {
        mProductDetails.remove(position);
        notifyDataSetChanged();
    }

    public interface OnCartProductListener {
        void removedCartItem(View v, int position);
    }

    class CartDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        @BindView(R.id.item_thumb)
        ImageView imageView;

        @BindView(R.id.item_name)
        TextView name;

        @BindView(R.id.item_price)
        TextView price;

        @BindView(R.id.item_quantity)
        TextView quantity;

        @BindView(R.id.item_remove_cart_product)
        Button itemRemoveCartProduct;



        public CartDetailViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(this);
            itemRemoveCartProduct.setOnClickListener(this);
            v.setTag(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.item_remove_cart_product : mOnCartProductListener.removedCartItem(view, getAdapterPosition());
            }
        }
    }
}

