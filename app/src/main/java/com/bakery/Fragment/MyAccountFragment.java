package com.bakery.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bakery.R;

/**
 * Created by system2 on 08-Jan-18.
 */

public class MyAccountFragment extends Fragment {
    LinearLayout Layout_accound,Layout_adress,Layout_order,Layout_dowload,Layout_product,Layout_wish_list,
            Layout_newslettet,Layout_payment,Layout_billing;
    Toolbar toolbar;
    TextView text_visible;
    ImageView logo_visible;
    public MyAccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.my_account_fragment, container, false);

        Layout_accound= (LinearLayout)view.findViewById(R.id.view_account);
        Layout_adress= (LinearLayout)view.findViewById(R.id.view_address);
        Layout_order= (LinearLayout)view.findViewById(R.id.view_my_order);
        Layout_dowload= (LinearLayout)view.findViewById(R.id.view_download_product);
        Layout_product= (LinearLayout)view.findViewById(R.id.view_my_product_review);
        Layout_wish_list= (LinearLayout)view.findViewById(R.id.view_my_wish_list);
        Layout_newslettet= (LinearLayout)view.findViewById(R.id.view_newsletter);
        Layout_payment= (LinearLayout)view.findViewById(R.id.view_payment_method);
        Layout_billing= (LinearLayout)view.findViewById(R.id.view_billing);

        tool_set();
        Layout_accound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=8;
                Accound_information_Fragment fragment = new Accound_information_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        Layout_adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=8;
                Address_book_Fragment fragment = new Address_book_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        Layout_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=8;
                MyOrder_Fragment fragment = new MyOrder_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        Layout_dowload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=8;
                Download_Product_Fragment fragment = new Download_Product_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        Layout_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=8;
                My_Product_Review_Fragment fragment = new My_Product_Review_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        Layout_wish_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=8;
                Wish_List_Fragment fragment = new Wish_List_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        Layout_newslettet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=8;
                News_Letter_Fragment fragment = new News_Letter_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        Layout_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=8;
                Store_Payment_Method_Fragment fragment = new Store_Payment_Method_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        Layout_billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=8;
                Billing_Agreement_Fragment fragment = new Billing_Agreement_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });

        return view;
}
    void tool_set(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        text_visible=(TextView)getActivity().findViewById(R.id.text_visible);
        logo_visible=(ImageView)getActivity().findViewById(R.id.logo_visible);
        logo_visible.setVisibility(View.GONE);
        text_visible.setVisibility(View.VISIBLE);
        text_visible.setText("My Account");
    }
}