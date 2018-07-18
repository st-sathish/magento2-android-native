package com.bakery.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bakery.R;

/**
 * Created by system2 on 17-Jan-18.
 */

public class Fragment_IceCreamWholesale extends Fragment {
LinearLayout linearLayout1;
    Toolbar toolbar;
    TextView text_visible;
    ImageView logo_visible;
    public Fragment_IceCreamWholesale() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_ice_cream_wholesale, container, false);
        tool_set();
        linearLayout1=(LinearLayout) view.findViewById(R.id.layout);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=4;
                Fragment_Item_List fragment1 = new Fragment_Item_List();
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
        text_visible.setText("IceCream Wholesale");
    }
}
