package com.bakery.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.network.models.ApiProductDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDetailListAdapter extends RecyclerView.Adapter<ProductDetailListAdapter.ProductDetailViewHolder> {

    private List<ApiProductDetail> mProductDetails = new ArrayList<>();

    private Context mContext;

    public ProductDetailListAdapter(Context context) {
        mContext = context;
    }

    public void update(ApiProductDetail productDetail) {
        mProductDetails.add(productDetail);
        notifyDataSetChanged();
    }

    @Override
    public ProductDetailListAdapter.ProductDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ProductDetailListAdapter.ProductDetailViewHolder(inflater.inflate(R.layout.item_product_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductDetailListAdapter.ProductDetailViewHolder viewHolder, int position) {
        ApiProductDetail productDetail = mProductDetails.get(position);
        viewHolder.name.setText(productDetail.getName());
    }

    @Override
    public int getItemCount() {
        return mProductDetails != null ? mProductDetails.size() : 0;
    }

    class ProductDetailViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ProductDetailViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.product_name);
        }
    }
}
