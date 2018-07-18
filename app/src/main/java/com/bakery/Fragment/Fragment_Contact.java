package com.bakery.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bakery.R;

/**
 * Created by system2 on 15-Jan-18.
 */

public class Fragment_Contact extends Fragment {
    public static Fragment newInstance(Context context) {
        Fragment_Contact f = new Fragment_Contact();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_contact_us, null);


        return root;
    }
}
