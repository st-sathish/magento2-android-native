package com.bakery.Fragment;

import android.content.Context;
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
 * Created by system2 on 09-Jan-18.
 */

public class MyOrder_Fragment  extends Fragment {
    LinearLayout new_address_button;
    TextView view1,record1;
    Toolbar toolbar;
    TextView text_visible;
    ImageView logo_visible;
    public MyOrder_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.my_order_fragment, container, false);

        view1=(TextView) view.findViewById(R.id.view1);
        record1=(TextView) view.findViewById(R.id.reorder1);
        tool_set();
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=7;
                View_Item_Fragment fragment = new View_Item_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        record1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=7;
                Reorder_Fragment fragment1 = new Reorder_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
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
        text_visible.setText("My Order");
    }
}
