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
import com.bakery.ui.listeners.OnProductClickListener;
import com.bakery.utils.ProductImageUtils;
import com.bakery.utils.ProductUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductDetailViewHolder> {

    private List<ProductResponse> mProductDetails = new ArrayList<>();

    private Context mContext;

    private OnProductClickListener mListener;

    private int mLayout;

    public ProductListAdapter(Context context, OnProductClickListener onItemClickListener, int layout) {
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

        @BindView(R.id.remove_item)
        TextView removeItem;

        @BindView(R.id.add_item)
        TextView addItem;

        @BindView(R.id.item_quantity)
        TextView quantity;

        @BindView(R.id.item_cart)
        ImageView itemCart;

        //@BindView(R.id.item_compare)
        //ImageView itemCompare;

        public ProductDetailViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(this);
            addItem.setOnClickListener(this);
            removeItem.setOnClickListener(this);
            itemCart.setOnClickListener(this);
            //itemCompare.setOnClickListener(this);
            v.setTag(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.add_item:
                    quantity.setText(ProductUtils.increaseItemQuantity(quantity.getText().toString()));
                    break;
                case R.id.remove_item:
                    quantity.setText(ProductUtils.deceaseItemQuantity(quantity.getText().toString()));
                    break;
                case R.id.item_cart:
                    mListener.onAddCartClick(v, getAdapterPosition(), quantity.getText().toString());
                    break;
                /*case R.id.item_compare:
                    mListener.onCompareClick(v, getAdapterPosition());
                    break;*/
            }
        }
    }
}
