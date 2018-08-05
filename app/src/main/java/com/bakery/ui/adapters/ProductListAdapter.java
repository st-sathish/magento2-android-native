package com.bakery.ui.adapters;

import android.content.Context;
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
        final ProductDetailViewHolder holder = new ProductListAdapter.ProductDetailViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(v, holder.getAdapterPosition());
            }
        });
        return holder;
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

    class ProductDetailViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        ImageView imageView;

        public ProductDetailViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.product_name);
            price = v.findViewById(R.id.product_price);
            imageView = v.findViewById(R.id.product_img);
        }
    }
}
