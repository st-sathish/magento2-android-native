package com.bakery.ui.landingpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.CartRequest;
import com.bakery.data.network.models.CartResponse;
import com.bakery.data.network.models.ProductResponse;
import com.bakery.ui.BaseAppCompatActivity;
import com.bakery.ui.fragments.address.AddressFragment;
import com.bakery.ui.fragments.mycart.MyCartFragment;
import com.bakery.ui.fragments.category.ExpCategoryFragment;
import com.bakery.ui.fragments.drawer.FragmentDrawer;
import com.bakery.ui.fragments.comingsoon.ComingSoonFragment;
import com.bakery.ui.fragments.home.HomeFragment;
import com.bakery.ui.fragments.product.ProductListFragment;
import com.bakery.ui.fragments.product.detail.ProductDetailFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LandingPageActivity extends BaseAppCompatActivity implements FragmentDrawer.FragmentDrawerListener, LandingPageMvpView  {

    public static final int FRAGMENT_DEFAULT = 1;
    public static final int FRAGMENT_HOME = 2;
    public static final int FRAGMENT_EXP_CATEGORY = 3;
    public static final int FRAGMENT_DETAIL_LIST_PRODUCT = 4;
    public static final int FRAGMENT_DETAILS_PRODUCT = 5;
    public static final int FRAGMENT_ADDRESS = 6;
    public static final int FRAGMENT_MY_CART = 7;

    private FragmentDrawer drawerFragment;
    private LandingPageMvpPresenter<LandingPageMvpView> mPresenter = null;

    @BindView(R.id.item_count)
    TextView itemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_landing_page);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setUnBinder(ButterKnife.bind(this));
        mPresenter = new LandingPagePresenter<>();
        mPresenter.onAttach(this);
        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        //load default
        displayView(FRAGMENT_HOME, "", false);
        // get cart count
        mPresenter.getCartList();
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
            case FRAGMENT_DETAIL_LIST_PRODUCT:
                title = "";
                fragment = ProductListFragment.newInstance(title);
                break;
            case FRAGMENT_DETAILS_PRODUCT:
                title = "";
                fragment = ProductDetailFragment.newInstance(title);
                break;
            case FRAGMENT_ADDRESS:
                title = "";
                fragment = AddressFragment.newInstance(title);
                break;
            case FRAGMENT_MY_CART:
                title = "";
                fragment = MyCartFragment.newInstance(title);
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

    @OnClick(R.id.item_counter)
    public void onCartClick() {
        displayView(LandingPageActivity.FRAGMENT_MY_CART, "My Cart", true);
    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            return;
        }
        getFragmentManager().popBackStack();
    }

    @Override
    public void updateCartCount(String count) {
        itemCount.setText(count);
    }

    @Override
    public void doIncrementCartCount(Integer count) {
        count +=1;
        updateCartCount(String.valueOf(count));
    }

    @Override
    public void addCartToMyAccount(ProductResponse response, String quantity) {
        Toast.makeText(this, "Adding to My Cart", Toast.LENGTH_SHORT).show();
        Integer q = Integer.parseInt(quantity);
        CartRequest.CartItem cartItem = new CartRequest.CartItem(SessionStore.quoteId, response.getSku(), q);
        CartRequest request = new CartRequest(cartItem);
        mPresenter.addCart(request);
    }

    @Override
    public void cartAddedCallback(CartResponse cartResponse) {
        Integer count = Integer.parseInt(itemCount.getText().toString());
        itemCount.setText((count > 0)
                ? String.valueOf(count + cartResponse.getQty())
                : String.valueOf(cartResponse.getQty()));
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
