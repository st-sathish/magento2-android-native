package com.bakery.ui.fragments.address;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bakery.R;
import com.bakery.ui.BaseFragment;
import com.bakery.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressFragment extends BaseFragment implements AddressMvp {


    @BindView(R.id.first_name)
    EditText firstName;

    @BindView(R.id.last_name)
    EditText lastName;

    @BindView(R.id.phone_number)
    EditText phone;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.street_address)
    EditText street;

    @BindView(R.id.city)
    EditText city;

    @BindView(R.id.state)
    EditText state;

    @BindView(R.id.postal_code)
    EditText zipcode;

    @BindView(R.id.country)
    EditText country;

    AddressPresenter mvpPresenter;

    public static AddressFragment newInstance(String title) {
        AddressFragment addressFragment = new AddressFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        addressFragment.setArguments(bundle);
        return addressFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.billing_address, container, false);
        mvpPresenter = new AddressPresenter<>();
        setUnBinder(ButterKnife.bind(this, view));
        mvpPresenter.onAttach(this);
        return view;
    }

    @OnClick(R.id.button_place_order)
    public void placeOrder() {
        mvpPresenter.placeOrder("sankar@gmail.com");
    }

    @Override
    public void onDestroy() {
        mvpPresenter.onDetach();
        super.onDestroy();
    }
}
