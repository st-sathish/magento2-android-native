package com.bakery.ui.fragments.address;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bakery.R;
import com.bakery.data.SessionStore;
import com.bakery.data.network.models.AddressModel;
import com.bakery.data.network.models.OrderRequest;
import com.bakery.ui.BaseFragment;
import com.bakery.ui.landingpage.LandingPageActivity;
import com.bakery.utils.AppConstants;
import com.bakery.utils.ValidationUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShippingAddressFragment extends BaseFragment implements AddressMvp{

    AddressPresenter mvpPresenter;

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

    public static ShippingAddressFragment newInstance(String title) {
        ShippingAddressFragment addressFragment = new ShippingAddressFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.INTENT_PARAM_ONE, title);
        addressFragment.setArguments(bundle);
        return addressFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_shipping_address, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        mvpPresenter = new AddressPresenter<>();
        mvpPresenter.onAttach(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.orderButton)
    public void onClick() {
        String firstNameValue = firstName.getText().toString();
        if (firstNameValue.isEmpty()) {
            onError(R.string.empty_first_name);
            return;
        }

        String lastNameValue = lastName.getText().toString();
        if (lastNameValue.isEmpty()) {
            onError(R.string.empty_last_name);
            return;
        }

        String phoneValue = phone.getText().toString();
        if (phoneValue.isEmpty()) {
            onError(R.string.empty_telephone);
            return;
        }

        String emailValue = email.getText().toString();
        if (emailValue == null || emailValue.isEmpty()) {
            onError(R.string.empty_email);
            return;
        }
        if(!ValidationUtils.isEmailValid(emailValue)) {
            onError(R.string.invalid_email);
            return;
        }

        String streetValue = street.getText().toString();
        if (streetValue.isEmpty()) {
            onError(R.string.empty_street);
            return;
        }

        String cityValue = city.getText().toString();
        if (cityValue.isEmpty()) {
            onError(R.string.empty_city);
            return;
        }

        String stateValue = state.getText().toString();
        if (stateValue.isEmpty()) {
            onError(R.string.empty_state);
            return;
        }

        String zipcodeValue = zipcode.getText().toString();
        if (zipcodeValue.isEmpty()) {
            onError(R.string.empty_post_code);
            return;
        }

        String countryValue = country.getText().toString();
        if (countryValue.isEmpty()) {
            onError(R.string.empty_country);
            return;
        }

        OrderRequest order = new OrderRequest();
        OrderRequest.PaymentMethod payment = new OrderRequest.PaymentMethod();
        payment.setMethod("banktransfer");
        order.setPaymentMethod(payment);
        OrderRequest.BillingAddress bill = new OrderRequest.BillingAddress();
        bill.setEmail(emailValue);
        bill.setCity(cityValue);
        bill.setCountry(countryValue);
        bill.setFirstName(firstNameValue);
        bill.setLastName(lastNameValue);
        bill.setPostcode(zipcodeValue);
        bill.setPhone_number(phoneValue);
        bill.setRegion(stateValue);
        bill.setRegion_code(stateValue);
        bill.setRegion_id(0);
        ArrayList<String> places = new ArrayList<String>();
        places.add(streetValue);
        bill.setStreet(places);
        order.setBillingAddress(bill);


        AddressModel addressModel = new AddressModel();
        AddressModel.AddressInformation info = new AddressModel.AddressInformation();
        AddressModel.AddressInformation.Address address = new AddressModel.AddressInformation.Address();
        address.setEmail(emailValue);
        address.setCity(cityValue);
        address.setCountry(countryValue);
        address.setFirstName(firstNameValue);
        address.setLastName(lastNameValue);
        address.setPostcode(zipcodeValue);
        address.setPhone_number(phoneValue);
        address.setRegion(stateValue);
        address.setRegion_code(stateValue);
        address.setRegion_id(0);
        places.clear();
        places.add(streetValue);
        address.setStreet(places);
        info.setBillingAddress(address);
        info.setShippingAddress(address);
        addressModel.setAddresses(info);
        mvpPresenter.setAddress(addressModel);

    }

    @Override
    public void addressCallback() {

        String firstNameValue = firstName.getText().toString();
        String lastNameValue = lastName.getText().toString();
        String phoneValue = phone.getText().toString();
        String emailValue = email.getText().toString();
        String streetValue = street.getText().toString();
        String cityValue = city.getText().toString();
        String stateValue = state.getText().toString();
        String zipcodeValue = zipcode.getText().toString();
        String countryValue = country.getText().toString();

        OrderRequest order = new OrderRequest();
        OrderRequest.PaymentMethod payment = new OrderRequest.PaymentMethod();
        payment.setMethod("banktransfer");
        order.setPaymentMethod(payment);
        OrderRequest.BillingAddress bill = new OrderRequest.BillingAddress();
        bill.setEmail(emailValue);
        bill.setCity(cityValue);
        bill.setCountry(countryValue);
        bill.setFirstName(firstNameValue);
        bill.setLastName(lastNameValue);
        bill.setPostcode(zipcodeValue);
        bill.setPhone_number(phoneValue);
        bill.setRegion(stateValue);
        bill.setRegion_code(stateValue);
        bill.setRegion_id(0);
        ArrayList<String> places = new ArrayList<String>();
        places.add(streetValue);
        bill.setStreet(places);
        order.setBillingAddress(bill);

        mvpPresenter.placeOrder(order);

    }

    @Override
    public void orderCallback() {
        Toast.makeText(getActivity(), "Order is placed.", Toast.LENGTH_LONG).show();
        SessionStore.quoteId = 0;
        getActivity().recreate();
        switchFragment(LandingPageActivity.FRAGMENT_HOME, "Home", false); //Commented out because, this does not show the crucial top bar - app_bar_main1.xml
    }

}
