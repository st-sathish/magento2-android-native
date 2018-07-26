package com.bakery.ui.fragments.category;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.adapters.ExpCategoryAdapter;
import com.bakery.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpCategoryFragment extends BaseFragment implements ExpCategoryMvpView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ExpCategoryMvpPresenter<ExpCategoryMvpView> mPresenter = new ExpCategoryPresenter<>();

    public ExpCategoryFragment() {

    }

    public static ExpCategoryFragment newInstance(String title) {
        ExpCategoryFragment expCategoryFragment = new ExpCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        expCategoryFragment.setArguments(bundle);
        return expCategoryFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_exp_category, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        setRecyclerViewAdapter();
        return view;
    }

    public void setRecyclerViewAdapter() {
        ExpCategoryAdapter categoryAdapter = new ExpCategoryAdapter(getActivity(), SessionStore.sSelectedExpandableCategory);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(categoryAdapter);
    }
}
