package com.bakery.ui.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.ui.listeners.OnItemClickListener;
import com.bakery.utils.ProductImageUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductDetailViewHolder> {

    private List<ProductResponse> mProductDetails = new ArrayList<>();

    private Context mContext;

    private OnItemClickListener mListener;

    private int mLayout;

    public ProductListAdapter(Context context, OnItemClickListener onItemClickListener, int layout) {
        mContext = context;
        this.mListener = onItemClickListener;
        this.mLayout = layout;
    }

    public void update(List<ProductResponse> productDetails) {
        mProductDetails.addAll(productDetails);
        notifyDataSetChanged();
    }

    public ProductResponse getItem(int position) {
        return mProductDetails.get(position);
    }

    @Override
    public ProductListAdapter.ProductDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(mLayout, parent, false);
        return new ProductListAdapter.ProductDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductDetailViewHolder itemHolder, int position) {
        ProductResponse productDetail = mProductDetails.get(position);
        itemHolder.name.setText(productDetail.getName());
        String price = mContext.getResources().getString(R.string.Rs)+" " +String.valueOf(productDetail.getPrice());
        itemHolder.price.setText(price);
        ProductImageUtils.loadImage(mContext, itemHolder.imageView, productDetail);
    }

    @Override
    public int getItemCount() {
        return mProductDetails != null ? mProductDetails.size() : 0;
    }

    class ProductDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.item_thumb)
        ImageView imageView;

        @BindView(R.id.item_name)
        TextView name;

        @BindView(R.id.item_price)
        TextView price;

        public ProductDetailViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getAdapterPosition());
        }

        /*@OnClick(R.id.add_item)
        public void onAddItem(View v) {
            TextView view = v.findViewById(R.id.item_quantity);
            view.setText(Integer.valueOf(view.getText().toString()) + 1);
        }

        @OnClick(R.id.remove_item)
        public void onRemoveItem(View v) {
            TextView view = v.findViewById(R.id.item_quantity);
            view.setText(Integer.valueOf(view.getText().toString()) - 1);
        }*/
    }
}
