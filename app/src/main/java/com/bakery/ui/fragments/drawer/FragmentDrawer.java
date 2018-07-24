package com.bakery.ui.fragments.drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bakery.R;
import com.bakery.data.network.models.CategoryResponse;
import com.bakery.data.ui.NavListItem;
import com.bakery.data.ui.models.GeneralItem;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.adapters.NavItemDrawerAdapter;
import com.bakery.ui.sections.CategorySection;
import com.bakery.ui.sections.GeneralSection;
import com.bakery.utils.extras.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class FragmentDrawer extends BaseFragment implements View.OnClickListener, FragmentDrawerMvpView {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView;
    private FragmentDrawerListener drawerListener;
    private SectionedRecyclerViewAdapter adapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    FragmentDrawerMvpPresenter<FragmentDrawerMvpView> mPresenter = null;

    public FragmentDrawer() {
        //must need default constructor
    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating view layout
        View view = inflater.inflate(R.layout.fr_navigation_drawer, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        adapter = new SectionedRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(
                getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                mDrawerLayout.closeDrawer(containerView);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        initializePresenter();
        return view;
    }

    private void initializePresenter() {
        String[] offers = getResources().getStringArray(R.array.list_sub_item);
        String[] accounts = getResources().getStringArray(R.array.list_item_account);
        String[] services = getResources().getStringArray(R.array.list_item_help);
        mPresenter = new FragmentDrawerPresenter<>(offers, accounts, services);
        mPresenter.onAttach(FragmentDrawer.this);
        mPresenter.fetchCategories();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (null != getActivity()) {
                    getActivity().invalidateOptionsMenu();
                }
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context,
                                     final RecyclerView recyclerView,
                                     final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context,
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override
                        public boolean onSingleTapUp(MotionEvent e) {
                            return true;
                        }

                        @Override
                        public void onLongPress(MotionEvent e) {
                            View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                            if (child != null && clickListener != null) {
                                clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                            }
                        }
                    });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null
                    && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(
                boolean disallowIntercept) {

        }

    }

    public interface FragmentDrawerListener {
        void onDrawerItemSelected(View view, int position);
    }

    @Override
    public void onClick(View v) {
        mDrawerLayout.closeDrawer(containerView);
    }

    public void toggleDrawer() {
        mDrawerLayout.openDrawer(containerView);
    }

    @Override
    public void setNavMenuItem(List<NavListItem> categoryItems, List<NavListItem> offerItems,
                               List<NavListItem> accountItems, List<NavListItem> serviceItems) {
        adapter.addSection("Category", new CategorySection(this, "Category", categoryItems));
        adapter.addSection("Offers", new GeneralSection("Offers", offerItems));
        adapter.addSection("My Accounts", new GeneralSection("My Accounts", accountItems));
        adapter.addSection("Terms & Conditions", new GeneralSection("Terms & Conditions", serviceItems));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }
}
