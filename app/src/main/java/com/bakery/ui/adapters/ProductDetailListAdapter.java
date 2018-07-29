package com.bakery.ui.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.network.models.ApiMediaGalleryEntry;
import com.bakery.data.network.models.ApiProductDetail;
import com.bakery.ui.listeners.OnItemClickListener;
import com.bakery.utils.ComponentUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailListAdapter extends RecyclerView.Adapter<ProductDetailListAdapter.ProductDetailViewHolder> {

    private List<ApiProductDetail> mProductDetails = new ArrayList<>();

    private Context mContext;

    private OnItemClickListener mListener;

    public ProductDetailListAdapter(Context context, OnItemClickListener onItemClickListener) {
        mContext = context;
        this.mListener = onItemClickListener;
    }

    public void update(List<ApiProductDetail> productDetails) {
        mProductDetails.addAll(productDetails);
        notifyDataSetChanged();
    }

    public ApiProductDetail getItem(int position) {
        return mProductDetails.get(position);
    }

    @Override
    public ProductDetailListAdapter.ProductDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_product_detail_list, parent, false);
        final ProductDetailViewHolder holder = new ProductDetailListAdapter.ProductDetailViewHolder(view);
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
        ApiProductDetail productDetail = mProductDetails.get(position);
        itemHolder.name.setText(productDetail.getName());
        String price = mContext.getResources().getString(R.string.Rs)+" " +String.valueOf(productDetail.getPrice());
        itemHolder.price.setText(price);
        ComponentUtils.loadImage(mContext, itemHolder.imageView, productDetail.getMediaGalleryEntries());
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
