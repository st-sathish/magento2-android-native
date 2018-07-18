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
 * Created by system2 on 17-Jan-18.
 */

public class Fragment_Allcatecories extends Fragment {
    LinearLayout menu1,menu2,menu3,menu4,menu5,menu6;
    LinearLayout view_menu1,view_menu2,view_menu3,view_menu4,view_menu5,view_menu6;
    Toolbar toolbar;
    TextView text_visible;
    ImageView logo_visible;
    ImageView minus1,minus2,minus3,minus4,minus5,minus6,pluse1,pluse2,pluse3,pluse4,pluse5,pluse6;
    Boolean click_event1=true,click_event2=true,click_event3=true,click_event4=true,click_event5=true,click_event6=true;

    public Fragment_Allcatecories() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_allcategories, container, false);


        menu1=(LinearLayout)view.findViewById(R.id.menu1);
        menu2=(LinearLayout)view.findViewById(R.id.menu2);
        menu3=(LinearLayout)view.findViewById(R.id.menu3);
        menu4=(LinearLayout)view.findViewById(R.id.menu4);
        menu5=(LinearLayout)view.findViewById(R.id.menu5);
        menu6=(LinearLayout)view.findViewById(R.id.menu6);
        view_menu1=(LinearLayout)view.findViewById(R.id.view_menu1);
        view_menu2=(LinearLayout)view.findViewById(R.id.view_menu2);
        view_menu3=(LinearLayout)view.findViewById(R.id.view_menu3);
        view_menu4=(LinearLayout)view.findViewById(R.id.view_menu4);
        view_menu5=(LinearLayout)view.findViewById(R.id.view_menu5);
        view_menu6=(LinearLayout)view.findViewById(R.id.view_menu6);
        minus1=(ImageView)view.findViewById(R.id.menu1_minus);
        minus2=(ImageView)view.findViewById(R.id.menu2_minus);
        minus3=(ImageView)view.findViewById(R.id.menu3_minus);
        minus4=(ImageView)view.findViewById(R.id.menu4_minus);
        minus5=(ImageView)view.findViewById(R.id.menu5_minus);
        minus6=(ImageView)view.findViewById(R.id.menu6_minus);
        pluse1=(ImageView)view.findViewById(R.id.menu1_pluse);
        pluse2=(ImageView)view.findViewById(R.id.menu2_pluse);
        pluse3=(ImageView)view.findViewById(R.id.menu3_pluse);
        pluse4=(ImageView)view.findViewById(R.id.menu4_pluse);
        pluse5=(ImageView)view.findViewById(R.id.menu5_pluse);
        pluse6=(ImageView)view.findViewById(R.id.menu6_pluse);

        tool_set();

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_menu1();
            }
        });
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_menu2();
            }
        });
        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_menu3();
            }
        });
        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_menu4();
            }
        });
        menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_menu5();
            }
        });
        menu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_menu6();
            }
        });

        view_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=13;
                Fragment_Item_List  fragment1 = new Fragment_Item_List();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        view_menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=13;
                Fragment_Item_List  fragment1 = new Fragment_Item_List();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        view_menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=13;
                Fragment_Item_List  fragment1 = new Fragment_Item_List();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        view_menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=13;
                Fragment_Item_List  fragment1 = new Fragment_Item_List();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        view_menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=13;
                Fragment_Item_List  fragment1 = new Fragment_Item_List();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        view_menu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=13;
                Fragment_Item_List  fragment1 = new Fragment_Item_List();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        return view;
    }

    void show_menu1(){

        if (click_event1==true){
            view_menu1.setVisibility(View.VISIBLE);
            click_event1=false;
            minus1.setVisibility(View.VISIBLE);
            pluse1.setVisibility(View.GONE);
        }
        else {
            view_menu1.setVisibility(View.GONE);
            click_event1=true;
            minus1.setVisibility(View.GONE);
            pluse1.setVisibility(View.VISIBLE);
        }
    }
    void show_menu2(){
        if (click_event2==true){
            view_menu2.setVisibility(View.VISIBLE);
            click_event2=false;
            minus2.setVisibility(View.VISIBLE);
            pluse2.setVisibility(View.GONE);
        }
        else {
            view_menu2.setVisibility(View.GONE);
            click_event2=true;
            minus2.setVisibility(View.GONE);
            pluse2.setVisibility(View.VISIBLE);
        }
    }
    void show_menu3(){
        if (click_event3==true){
            view_menu3.setVisibility(View.VISIBLE);
            click_event3=false;
            minus3.setVisibility(View.VISIBLE);
            pluse3.setVisibility(View.GONE);
        }
        else {
            view_menu3.setVisibility(View.GONE);
            click_event3=true;
            minus3.setVisibility(View.GONE);
            pluse3.setVisibility(View.VISIBLE);
        }
    }
    void show_menu4(){
        if (click_event4==true){
            view_menu4.setVisibility(View.VISIBLE);
            click_event4=false;
            minus4.setVisibility(View.VISIBLE);
            pluse4.setVisibility(View.GONE);
        }
        else {
            view_menu4.setVisibility(View.GONE);
            click_event4=true;
            minus4.setVisibility(View.GONE);
            pluse4.setVisibility(View.VISIBLE);
        }
    }
    void show_menu5(){
        if (click_event5==true){
            view_menu5.setVisibility(View.VISIBLE);
            click_event5=false;
            minus5.setVisibility(View.VISIBLE);
            pluse5.setVisibility(View.GONE);
        }
        else {
            view_menu5.setVisibility(View.GONE);
            click_event5=true;
            minus5.setVisibility(View.GONE);
            pluse5.setVisibility(View.VISIBLE);
        }
    }
    void show_menu6(){
        if (click_event6==true){
            view_menu6.setVisibility(View.VISIBLE);
            click_event6=false;
            minus6.setVisibility(View.VISIBLE);
            pluse6.setVisibility(View.GONE);
        }
        else {
            view_menu6.setVisibility(View.GONE);
            click_event6=true;
            minus6.setVisibility(View.GONE);
            pluse6.setVisibility(View.VISIBLE);
        }
    }
    void tool_set(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        text_visible=(TextView)getActivity().findViewById(R.id.text_visible);
        logo_visible=(ImageView)getActivity().findViewById(R.id.logo_visible);
        logo_visible.setVisibility(View.GONE);
        text_visible.setVisibility(View.VISIBLE);
        text_visible.setText("All Categories");
    }
}

/* menu1=(LinearLayout)view.findViewById(R.id.menu1);
        menu2=(LinearLayout)view.findViewById(R.id.menu2);
        menu3=(LinearLayout)view.findViewById(R.id.menu3);
        menu4=(LinearLayout)view.findViewById(R.id.menu4);
        menu5=(LinearLayout)view.findViewById(R.id.menu5);
        menu6=(LinearLayout)view.findViewById(R.id.menu6);

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonChange =8;
                Fragment_IceCream_Retail fragment1 = new Fragment_IceCream_Retail();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonChange =8;
                Fragment_Bakery_Retail fragment1 = new Fragment_Bakery_Retail();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonChange =8;
                Fragment_Beverages_Retail fragment1 = new Fragment_Beverages_Retail();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonChange =8;
                Fragment_IceCreamWholesale fragment1 = new Fragment_IceCreamWholesale();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonChange =8;
                Fragment_Bakery_Wholesale fragment1 = new Fragment_Bakery_Wholesale();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });
        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonChange =8;
                Fragment_BeveragesWholesale fragment1 = new Fragment_BeveragesWholesale();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment1);
                transaction.commit();
            }
        });*/