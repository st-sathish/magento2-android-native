package com.bakery.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bakery.R;

/**
 * Created by system2 on 09-Jan-18.
 */

public class Address_book_Fragment  extends Fragment {
    LinearLayout new_address_button;
    Toolbar toolbar;
    TextView text_visible;
    ImageView logo_visible;
    public Address_book_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.address_fragment, container, false);
        new_address_button=(LinearLayout)view.findViewById(R.id.new_address_button);
        tool_set();
        new_address_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=9;
                New_Address_Fragment fragment = new New_Address_Fragment();
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
        text_visible.setText("My Address");
    }
}
