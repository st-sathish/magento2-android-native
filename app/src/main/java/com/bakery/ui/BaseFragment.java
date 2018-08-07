package com.bakery.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.bakery.R;
import com.bakery.presenter.MvpView;
import com.bakery.ui.landingpage.LandingPageActivity;
import com.bakery.ui.landingpage.LandingPageMvpView;
import com.bakery.utils.AppConstants;
import com.bakery.utils.ComponentUtils;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseAppCompatActivity mActivity;
    private Unbinder mUnBinder;
    private ProgressDialog mProgressDialog;

    private String mTitle = "My Title";

    private Toolbar toolbar;

    protected boolean loadMoreRecord = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(null != getArguments()) {
            mTitle = getArguments().getString(AppConstants.INTENT_PARAM_ONE);
        }
        setHasOptionsMenu(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(null != getActivity()) {
            toolbar = getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle(mTitle);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseAppCompatActivity) {
            BaseAppCompatActivity activity = (BaseAppCompatActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = ComponentUtils.showLoadingDialog(this.getContext());
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (mActivity != null) {
            return mActivity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }
    }

    public BaseAppCompatActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    // protected abstract void setUp(View view);

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }

    public void switchFragment(int fragment, String title, boolean addToBackStack) {
        LandingPageActivity landingPageActivity = (LandingPageActivity) getActivity();
        if(null != landingPageActivity) {
            landingPageActivity.displayView(fragment, title, addToBackStack);
        }
    }

    protected void updateCartCount(String count) {
        LandingPageMvpView landingPageMvpView = (LandingPageActivity) getActivity();
        if(null != landingPageMvpView) {
            landingPageMvpView.updateCartCount(count);
        }
    }
}
