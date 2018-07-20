package com.bakery.ui.fragments.comingsoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bakery.R;

public class ComingSoonFragment extends Fragment {

    public ComingSoonFragment() {

    }

    public static ComingSoonFragment newInstance(String title) {
        ComingSoonFragment comingsoonFragment = new ComingSoonFragment();
        return comingsoonFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_coming_soon, container, false);
    }
}
