package com.bakery.ui.sections;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.network.models.CategoryResponse;
import com.bakery.data.ui.NavListItem;
import com.bakery.data.ui.models.CategoryItem;
import com.bakery.data.ui.models.GeneralItem;
import com.bakery.data.ui.models.NavItem;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

public class GeneralSection extends StatelessSection implements View.OnClickListener {

    private String title;

    private List<NavListItem> mNavItems;

    public GeneralSection(String title, List<NavListItem> list) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.item_general_section)
                .headerResourceId(R.layout.section_header)
                .build());
        this.title = title;
        this.mNavItems = list;
    }

    @Override
    public int getContentItemsTotal() {
        return mNavItems.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new GeneralItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        GeneralItemViewHolder itemHolder = (GeneralItemViewHolder) holder;
        GeneralItem generalItem   = (GeneralItem) mNavItems.get(position);
        itemHolder.title.setText(generalItem.getNavItem().getName());
        itemHolder.iconView.setImageResource(generalItem.getNavItem().getIcon());
        itemHolder.rootView.setOnClickListener(this);
        itemHolder.rootView.setTag(position);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
        headerHolder.tvTitle.setText(title);
    }

    @Override
    public void onClick(View v) {
        Integer position = (Integer) v.getTag();
        GeneralItem generalItem   = (GeneralItem) mNavItems.get(position);
        NavItem navItem = generalItem.getNavItem();
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;

        HeaderViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
        }
    }

    class GeneralItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ImageView iconView;
        private final View rootView;

        GeneralItemViewHolder(View v) {
            super(v);
            rootView = v;
            title = itemView.findViewById(R.id.title);
            iconView = itemView.findViewById(R.id.icon);
        }
    }
}
