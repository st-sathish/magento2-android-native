package com.bakery.ui.sections;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.CategoryResponse;
import com.bakery.data.ui.NavListItem;
import com.bakery.data.ui.models.CategoryItem;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.landingpage.LandingPageActivity;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

public class CategorySection extends StatelessSection {

    private String title;

    private List<NavListItem> mNavItems;

    private BaseFragment mBaseFragment;

    public CategorySection(BaseFragment baseFragment, String title, List<NavListItem> list) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.item_navdrawer)
                .headerResourceId(R.layout.section_header)
                .build());
        this.title = title;
        this.mNavItems = list;
        this.mBaseFragment = baseFragment;
    }

    @Override
    public int getContentItemsTotal() {
        return mNavItems.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new CategoryItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final int position) {
        CategoryItemViewHolder itemHolder = (CategoryItemViewHolder) holder;
        CategoryItem categoryItem   = (CategoryItem) mNavItems.get(position);
        itemHolder.title.setText(categoryItem.getCategoryResponse().getName());
        itemHolder.iconView.setImageResource(categoryItem.getCategoryResponse().getIcon());
        // itemHolder.category_arrow_icon_layout.setTag(position);
        // itemHolder.category_layout.setTag(position);
        itemHolder.category_arrow_icon_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryItem categoryItem   = (CategoryItem) mNavItems.get(position);
                CategoryResponse categoryResponse = categoryItem.getCategoryResponse();
                String name = categoryResponse.getName();
                SessionStore.sSelectedExpandableCategory = categoryResponse.getChildrenData();
                mBaseFragment.switchFragment(LandingPageActivity.FRAGMENT_EXP_CATEGORY, name, true);
            }
        });
        itemHolder.category_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Integer position = (Integer) v.getTag();
                CategoryItem categoryItem   = (CategoryItem) mNavItems.get(position);
                String name = categoryItem.getCategoryResponse().getName();
                SessionStore.sSelectedCategory = categoryItem.getCategoryResponse();
                mBaseFragment.switchFragment(LandingPageActivity.FRAGMENT_DETAIL_LIST_PRODUCT, name, true);
            }
        });
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

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;

        HeaderViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
        }
    }

    class CategoryItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ImageView iconView;
        private final LinearLayout category_arrow_icon_layout;
        private final LinearLayout category_layout;

        CategoryItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            iconView = itemView.findViewById(R.id.icon);
            category_layout = itemView.findViewById(R.id.category_layout);
            category_arrow_icon_layout = itemView.findViewById(R.id.category_arrow_icon_layout);
        }
    }
}
