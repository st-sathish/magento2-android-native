package com.bakery.ui.landingpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bakery.R;
import com.bakery.ui.BaseAppCompatActivity;
import com.bakery.ui.fragments.category.ExpCategoryFragment;
import com.bakery.ui.fragments.drawer.FragmentDrawer;
import com.bakery.ui.fragments.comingsoon.ComingSoonFragment;
import com.bakery.ui.fragments.home.HomeFragment;

public class LandingPageActivity extends BaseAppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    public static final int FRAGMENT_DEFAULT = 1;
    public static final int FRAGMENT_HOME = 2;
    public static final int FRAGMENT_EXP_CATEGORY = 3;

    private FragmentDrawer drawerFragment;
    private LandingPageMvpPresenter mPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_landing_page);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        mPresenter = new LandingPagePresenter();
        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        //load default
        displayView(FRAGMENT_HOME, "", false);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

    }

    public void displayView(int position, String aTitle, boolean addToBackstack) {
        Fragment fragment = null;
        String title = null;
        switch (position) {
            case FRAGMENT_HOME:
                title = "Home";
                fragment = HomeFragment.newInstance(title);
                break;
            case FRAGMENT_EXP_CATEGORY:
                title = "";
                fragment = ExpCategoryFragment.newInstance(title);
                break;
            case FRAGMENT_DEFAULT:
            default:
                title = "Coming Soon";
                fragment = ComingSoonFragment.newInstance(title);
                break;
        }
        if (null != fragment) {
            switchFragment(fragment, title, addToBackstack);
        }
    }

    public void switchFragment(Fragment fragment, String title, boolean aAddtoBackstack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        String backStateName = ft.getClass().getName();
        //ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        ft.replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
        if (aAddtoBackstack)
            ft.addToBackStack(backStateName);
        ft.commit();
    }
}
