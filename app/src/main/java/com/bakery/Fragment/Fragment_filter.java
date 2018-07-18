package com.bakery.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bakery.R;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.IndicatorSeekBarType;
import com.warkiz.widget.IndicatorType;
import com.warkiz.widget.TickType;

/**
 * Created by system2 on 24-Jan-18.
 */

public class Fragment_filter extends Fragment {
    Toolbar toolbar;
    public Fragment_filter() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_filter, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        RamConstants.buttonclick=11;
       IndicatorSeekBar indicatorSeekBar = new IndicatorSeekBar.Builder(getActivity())
                .setMax(20000)
                .setMin(1000)
                .setProgress(3000)
                .setSeekBarType(IndicatorSeekBarType.DISCRETE_TICKS)
                .setTickType(TickType.OVAL)
                .setTickNum(9)
                .setBackgroundTrackSize(2)//dp size
                .setProgressTrackSize(3)//dp size
                //  .setIndicatorType(IndicatorType.SQUARE_CORNERS)
                .setIndicatorColor(Color.parseColor("#36b84e"))
                .build();

//change build params at the runtime.

        indicatorSeekBar.getBuilder()
                .setMax(232)
                .setMin(43)
                .setTickType(TickType.OVAL)
                .setTickColor(Color.parseColor("#0000FF"))
                .apply();

        return view;
    }}



