package com.bakery.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.network.models.CartListResponse;
import com.bakery.ui.listeners.OnProductClickListener;
import com.bakery.utils.ProductImageUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartDetailListAdapter extends RecyclerView.Adapter<CartDetailListAdapter.CartDetailViewHolder> {
    private List<CartListResponse> mProductDetails = new ArrayList<>();

    private Context mContext;

    private int mLayout;

    public CartDetailListAdapter(Context context, int layout) {
        mContext = context;
        this.mLayout = layout;
    }


    public CartListResponse getItem(int position) {
        return mProductDetails.get(position);
    }

    @Override
    public CartDetailListAdapter.CartDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(mLayout, parent, false);
        return new CartDetailListAdapter.CartDetailViewHolder(view);
    }

    public void updateAll(List<CartListResponse> productDetails) {
        mProductDetails.addAll(productDetails);
        notifyDataSetChanged();
    }

    public void update(CartListResponse productDetails) {
        mProductDetails.add(productDetails);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(CartDetailListAdapter.CartDetailViewHolder itemHolder, int position) {
        CartListResponse productDetail = mProductDetails.get(position);
        itemHolder.name.setText(productDetail.getItems().get(position).getName());
        String price = mContext.getResources().getString(R.string.Rs)+" " +String.valueOf(productDetail.getItems().get(position).getPrice());
        itemHolder.price.setText(price);
        ProductImageUtils.loadImage(mContext, itemHolder.imageView, "dummy");
    }

    @Override
    public int getItemCount() {
        return mProductDetails != null ? mProductDetails.size() : 0;
    }

    class CartDetailViewHolder extends RecyclerView.ViewHolder  {

        @BindView(R.id.item_thumb)
        ImageView imageView;

        @BindView(R.id.item_name)
        TextView name;

        @BindView(R.id.item_price)
        TextView price;

        @BindView(R.id.item_quantity)
        TextView quantity;


        public CartDetailViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }
}

