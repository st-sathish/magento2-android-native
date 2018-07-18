package com.bakery.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;

/**
 * Created by system2 on 09-Jan-18.
 */

public class New_Address_Fragment extends Fragment {
    Toolbar toolbar;
    TextView text_visible;
    ImageView logo_visible;
    public New_Address_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.new_address_fragment, container, false);
        tool_set();
        return view;
    }
    void tool_set(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        text_visible=(TextView)getActivity().findViewById(R.id.text_visible);
        logo_visible=(ImageView)getActivity().findViewById(R.id.logo_visible);
        logo_visible.setVisibility(View.GONE);
        text_visible.setVisibility(View.VISIBLE);
        text_visible.setText("Add New Address");
    }
}

