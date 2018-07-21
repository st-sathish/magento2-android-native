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

import java.util.List;

public class NavItemDrawerAdapter extends RecyclerView.Adapter<NavItemDrawerAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<CategoryResponse> mNavItems;

    public NavItemDrawerAdapter(Context context, List<CategoryResponse> navItems) {
        mContext = context;
        inflater = LayoutInflater.from(context);
        mNavItems = navItems;
    }

    public void delete(int position) {
        mNavItems.remove(position);
        notifyItemRemoved(position);
    }

    public void refresh(List<CategoryResponse> navItems) {
        this.mNavItems = navItems;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_navdrawer, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CategoryResponse current = mNavItems.get(position);
        holder.title.setText(current.getName());
        holder.iconView.setImageResource(current.getIcon());
    }

    @Override
    public int getItemCount() {
        return mNavItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView iconView;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            iconView = itemView.findViewById(R.id.icon);
        }
    }

}
