package com.bakery.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bakery.R;
import com.github.siyamed.shapeimageview.RoundedImageView;

/**
 * Created by system2 on 22-Dec-17.
 */

public class HomeFragment  extends Fragment implements View.OnClickListener {
    DrawerLayout drawer;
    RelativeLayout left_slider;
    ImageView preview_drawer;
    RoundedImageView image_round1,image_round2;
    LinearLayout search;
    NestedScrollView scrollView;
    Button views;
    public HomeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);

        drawer = (DrawerLayout)view .findViewById(R.id.drawer_layout);
      //  left_slider = (RelativeLayout)view.findViewById(R.id.slider);
        preview_drawer = (ImageView)view.findViewById(R.id.preview_drawer);
        search = (LinearLayout)view.findViewById(R.id.search_bar);
        scrollView = (NestedScrollView)view.findViewById(R.id.scrollView);
        image_round1=(RoundedImageView)view.findViewById(R.id.image1);
        image_round2=(RoundedImageView)view.findViewById(R.id.image2);
        views=(Button)view.findViewById(R.id.view_item);


        preview_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(left_slider);
            }
        });
       /* view.findViewById(R.id.button01).setOnClickListener(this);
        view.findViewById(R.id.button02).setOnClickListener(this);
        view.findViewById(R.id.button03).setOnClickListener(this);
*/
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
     /*   ((NavicationActivity) getActivity()).disableNavigationIcon();
        ((NavicationActivity) getActivity()).setToolbarTitle(R.string.MainFragmentTitle);*/
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

          /*  case R.id.button01:
                //Move to Fragment 01
                ((SplashScreenActivity) getActivity()).showFragment(new FragmentExample1());
                break;

            case R.id.button02:
                //Move to Fragment 02
                ((SplashScreenActivity) getActivity()).showFragment(new FragmentExample2());
                break;

            case R.id.button03:
                //Move to Fragment 03
                ((SplashScreenActivity) getActivity()).showFragment(new FragmentExample3());
                break;
*/
        }

    }
}
   /* DrawerLayout drawer;
    RelativeLayout left_slider;
    ImageView preview_drawer;
    RoundedImageView image_round1,image_round2;
    LinearLayout search;
    NestedScrollView scrollView;
    Button views;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.home_fragment, container,false);

        drawer = (DrawerLayout)view .findViewById(R.id.drawer_layout);
        left_slider = (RelativeLayout)view.findViewById(R.id.slider);
        preview_drawer = (ImageView)view.findViewById(R.id.preview_drawer);
        search = (LinearLayout)view.findViewById(R.id.search_bar);
        scrollView = (NestedScrollView)view.findViewById(R.id.scrollView);
        image_round1=(RoundedImageView)view.findViewById(R.id.image1);
        image_round2=(RoundedImageView)view.findViewById(R.id.image2);
        views=(Button)view.findViewById(R.id.view_item);

        views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        preview_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              drawer.openDrawer(left_slider);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

}*/
