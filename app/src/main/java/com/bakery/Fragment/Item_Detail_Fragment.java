package com.bakery.Fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bakery.Adapter.Product_Item_GridView_Adapter;
import com.bakery.Adapter.Product_Item_ListView_Adapter;
import com.bakery.Bean.ItemListBean;
import com.bakery.R;
import com.bakery.Source.RamVelConstant;
import com.bakery.Source.WebService;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by system2 on 30-Dec-17.
 */

public class Item_Detail_Fragment extends Fragment implements OnLikeListener{
    Toolbar toolbar;
    DrawerLayout drawer;
    LinearLayout sm_layout1, sm_layout2, sm_layout3, sm_layout4;
    LinearLayout favorite;
    LikeButton likeButton;
    ImageView fav, imageView_wish,image_purchase,image_zoom,image_in1,image_in2,image_in3,image_in4;
    WebService webService;
    ProgressDialog progressDialog;
    TextView name,count, quantity, price,item_price,text_description;
    int c, k, p,getprice;
    boolean click = true;
    boolean getvalue=true;
    public Item_Detail_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.item_detail_fragment, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        progressDialog = new ProgressDialog(getActivity(), R.style.Dialog);
        progressDialog.setCanceledOnTouchOutside(false);

        RamConstants.buttonclick=11;
        likeButton=(LikeButton)view.findViewById(R.id.star_button);
        LinearLayout minus = (LinearLayout) view.findViewById(R.id.minus);
        LinearLayout add_cart= (LinearLayout) view.findViewById(R.id.button_add_cart);
        LinearLayout pluse = (LinearLayout) view.findViewById(R.id.pluse);
        name=(TextView)view.findViewById(R.id.text_name);
        count = (TextView) view.findViewById(R.id.count);
        quantity = (TextView) view.findViewById(R.id.quantity);
        price = (TextView) view.findViewById(R.id.price);
        text_description = (TextView) view.findViewById(R.id.text_description);
        item_price = (TextView) view.findViewById(R.id.item_price);
        sm_layout1 = (LinearLayout) view.findViewById(R.id.small_layout1);
        sm_layout2 = (LinearLayout) view.findViewById(R.id.small_layout2);
        sm_layout3 = (LinearLayout) view.findViewById(R.id.small_layout3);
        sm_layout4 = (LinearLayout) view.findViewById(R.id.small_layout4);
        favorite = (LinearLayout) view.findViewById(R.id.image_favorite);
       // imageView_wish = (ImageView) view.findViewById(R.id.image_wishlist);
        image_purchase=(ImageView) view.findViewById(R.id.image_purchase);
        image_zoom = (ImageView) view.findViewById(R.id.image_zoom);
        image_in1 = (ImageView) view.findViewById(R.id.image_in1);
        image_in2 = (ImageView) view.findViewById(R.id.image_in2);
        image_in3 = (ImageView) view.findViewById(R.id.image_in3);
        image_in4 = (ImageView) view.findViewById(R.id.image_in4);

        setimage();
/*
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click==true){
                    click=false;
                    Toast.makeText(getActivity(),"Like",Toast.LENGTH_LONG).show();
                }
                else {
                    click=true;
                    Toast.makeText(getActivity(),"UnLike",Toast.LENGTH_LONG).show();
                }

            }
        });*/
     /*  favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click==true){
                    Toast.makeText(getActivity(),"Like",Toast.LENGTH_LONG).show();
                   // imageView_wish.setBackgroundResource(R.mipmap.favorite_red_image);
                    click=false;
                }
                else {
                    Toast.makeText(getActivity(),"UnLike",Toast.LENGTH_LONG).show();
                  //  imageView_wish.setBackgroundResource(R.mipmap.favorite_gray_image);
                    click=true;
                }
            }
        });*/
        sm_layout1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                sm_layout1.setBackgroundResource(R.drawable.layout_style);
                sm_layout2.setBackgroundResource(R.drawable.layout_style2);
                sm_layout3.setBackgroundResource(R.drawable.layout_style2);
                sm_layout4.setBackgroundResource(R.drawable.layout_style2);
               /* try {
                    Picasso.with(getActivity()).load(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getImage())
                            .into(image_zoom);
                }
                catch (Exception e){

                }*/
            }
        });
        sm_layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm_layout2.setBackgroundResource(R.drawable.layout_style);
                sm_layout1.setBackgroundResource(R.drawable.layout_style2);
                sm_layout3.setBackgroundResource(R.drawable.layout_style2);
                sm_layout4.setBackgroundResource(R.drawable.layout_style2);
               /* try {
                    Picasso.with(getActivity()).load(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getSmall_image())
                            .into(image_zoom);
                }
                catch (Exception e){

                }*/
            }
        });
        sm_layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm_layout3.setBackgroundResource(R.drawable.layout_style);
                sm_layout1.setBackgroundResource(R.drawable.layout_style2);
                sm_layout2.setBackgroundResource(R.drawable.layout_style2);
                sm_layout4.setBackgroundResource(R.drawable.layout_style2);
                /*try {
                    Picasso.with(getActivity()).load(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getThumbnail())
                            .into(image_zoom);
                }
                catch (Exception e){

                }*/
            }
        });
        sm_layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm_layout4.setBackgroundResource(R.drawable.layout_style);
                sm_layout2.setBackgroundResource(R.drawable.layout_style2);
                sm_layout3.setBackgroundResource(R.drawable.layout_style2);
                sm_layout1.setBackgroundResource(R.drawable.layout_style2);
              /*  try {
                    Picasso.with(getActivity()).load(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getSwatch_image())
                            .into(image_zoom);
                }
                catch (Exception e){

                }*/
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getprice= Integer.parseInt(item_price.getText().toString());
                c = Integer.parseInt(count.getText().toString());
                p = Integer.parseInt(price.getText().toString());
                k = Integer.parseInt(quantity.getText().toString());
                if (c <= 0 && k <= 0) {
                    count.setText("" + 0);
                    price.setText("" + 0);
                    quantity.setText("" + 0);
                } else {
                    c = c - 1;
                    count.setText("" + c);
                    quantity.setText("" + c);
                    price.setText("" + (p - getprice));
                  }
                if(c==0){
                    image_purchase.setVisibility(View.GONE);
                }
                else {
                    image_purchase.setVisibility(View.VISIBLE);
                }

            }
        });
        pluse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Integer.parseInt(count.getText().toString());
                p = Integer.parseInt(item_price.getText().toString());
                c = c + 1;
                count.setText("" + c);
                quantity.setText("" + c);
                price.setText("" + c*p);
                if(c==0){
                    image_purchase.setVisibility(View.GONE);
                }
                else {
                    image_purchase.setVisibility(View.VISIBLE);
                }
                   }
        });

        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Integer.parseInt(count.getText().toString());
                if(c==0){
                    Toast.makeText(getActivity(),"Quantity is 0 Please Purchase",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity(),"Your purchased item will be added later",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
    void setimage(){
        Bundle bundle = this.getArguments();
        if(bundle != null){
            // handle your code here.
            name.setText(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getName());
            item_price.setText(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getPrice());
            text_description.setText(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getDiscription());
        }
        try {
           Picasso.with(getActivity()).load(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getImage())
                    .into(image_in1);
            Picasso.with(getActivity()).load(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getSmall_image())
                    .into(image_in2);
            Picasso.with(getActivity()).load(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getThumbnail())
                    .into(image_in3);
            Picasso.with(getActivity()).load(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getSwatch_image())
                    .into(image_in4);
            Picasso.with(getActivity()).load(RamVelConstant.itemListBeans.get(bundle.getInt("pos")).getImage())
                    .into(image_zoom);

        }
        catch (Exception e){

        }
    }

    @Override
    public void liked(LikeButton likeButton) {

    }

    @Override
    public void unLiked(LikeButton likeButton) {

    }
}
