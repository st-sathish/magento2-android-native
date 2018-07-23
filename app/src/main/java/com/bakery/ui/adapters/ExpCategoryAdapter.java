package com.bakery.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.network.models.CategoryResponse;

import java.util.List;

public class ExpCategoryAdapter extends RecyclerView.Adapter<ExpCategoryAdapter.ItemSingleRowViewHolder> {

    private Context mContext;

    private List<CategoryResponse> mItems;

    public ExpCategoryAdapter(Context context, List<CategoryResponse> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public ExpCategoryAdapter.ItemSingleRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exp_category, parent, false);
        return new ItemSingleRowViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpCategoryAdapter.ItemSingleRowViewHolder viewHolder, int position) {
        CategoryResponse item = mItems.get(position);
        viewHolder.title.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    class ItemSingleRowViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ItemSingleRowViewHolder(View v) {
            super(v);
            title = itemView.findViewById(R.id.title);
        }
    }
}
