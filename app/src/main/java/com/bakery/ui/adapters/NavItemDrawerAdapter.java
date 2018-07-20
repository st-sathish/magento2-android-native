package com.bakery.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.ui.models.NavItem;

import java.util.Collections;
import java.util.List;

public class NavItemDrawerAdapter extends RecyclerView.Adapter<NavItemDrawerAdapter.MyViewHolder> {

    Context mContext;
    private LayoutInflater inflater;
    List<NavItem> mNavItems = Collections.emptyList();

    public NavItemDrawerAdapter(Context context, List<NavItem> navItems) {
        mContext = context;
        inflater = LayoutInflater.from(context);
        mNavItems = navItems;
    }

    public void delete(int position) {
        mNavItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_navdrawer, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavItem current = mNavItems.get(position);
        holder.title.setText(current.getItemName());
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
