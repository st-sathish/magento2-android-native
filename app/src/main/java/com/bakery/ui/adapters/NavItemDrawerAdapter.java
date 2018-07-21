package com.bakery.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.network.models.CategoryResponse;
import com.bakery.data.ui.NavListItem;
import com.bakery.data.ui.models.CategoryItem;
import com.bakery.data.ui.models.GeneralItem;

import java.util.List;

public class NavItemDrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<NavListItem> mNavItems;

    public NavItemDrawerAdapter(Context context, List<NavListItem> navItems) {
        mContext = context;
        mNavItems = navItems;
    }

    public void refresh(List<NavListItem> navItems) {
        this.mNavItems = navItems;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case NavListItem.TYPE_CATEGORY:
                viewHolder = new CategoryViewHolder(inflater.inflate(R.layout.item_navdrawer, parent, false));
                break;
            case NavListItem.TYPE_GENERAL:
                viewHolder = new GeneralViewHolder(inflater.inflate(R.layout.item_navdrawer, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case NavListItem.TYPE_CATEGORY:
                CategoryItem categoryItem = (CategoryItem) mNavItems.get(position);
                CategoryViewHolder categoryViewHolder = ( CategoryViewHolder ) viewHolder;
                categoryViewHolder.title.setText(categoryItem.getCategoryResponse().getName());
                categoryViewHolder.iconView.setImageResource(categoryItem.getCategoryResponse().getIcon());
            break;
            case NavListItem.TYPE_GENERAL:
                GeneralItem generalItem   = (GeneralItem) mNavItems.get(position);
                GeneralViewHolder generalViewHolder= (GeneralViewHolder) viewHolder;
                generalViewHolder.title.setText(generalItem.getNavItem().getName());
                generalViewHolder.iconView.setImageResource(generalItem.getNavItem().getIcon());
            break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mNavItems.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mNavItems != null ? mNavItems.size() : 0;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView iconView;

        public CategoryViewHolder(View v) {
            super(v);
            title = itemView.findViewById(R.id.title);
            iconView = itemView.findViewById(R.id.icon);
        }
    }

    class GeneralViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView iconView;

        public GeneralViewHolder(View v) {
            super(v);
            title = itemView.findViewById(R.id.title);
            iconView = itemView.findViewById(R.id.icon);
        }
    }
}
