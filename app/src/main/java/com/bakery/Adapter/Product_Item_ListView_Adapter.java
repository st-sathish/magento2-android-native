package com.bakery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bakery.Bean.CategoryBean;
import com.bakery.Bean.ItemListBean;
import com.bakery.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by system2 on 21-Feb-18.
 */

public class Product_Item_ListView_Adapter extends BaseAdapter{
    ArrayList<ItemListBean> list;
    Context context;
    ImageView image_favorite;

    public  Product_Item_ListView_Adapter(Context context, ArrayList<ItemListBean> list) {
        this.context = context;
        this.list=list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            view =new View(context);
            view=inflater.inflate(R.layout.list_item,null);
            LinearLayout layout_pluse=(LinearLayout)view.findViewById(R.id.pluse);
            ImageView product_image=(ImageView)view.findViewById(R.id.item_image);
            TextView text_name=(TextView)view.findViewById(R.id.item_name);
            TextView text_price=(TextView)view.findViewById(R.id.item_price);
            TextView text_kgs=(TextView)view.findViewById(R.id.item_kgs);
            image_favorite=(ImageView)view.findViewById(R.id.image_favorite);
            try {
                Picasso.with(context)
                        .load(list.get(position).getImage())
                        .into(product_image);
            }
            catch (Exception e){

            }
            text_name.setText(list.get(position).getName());
            text_price.setText(list.get(position).getPrice());

            layout_pluse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            image_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"*********"+position,Toast.LENGTH_LONG).show();
                    image_favorite.setVisibility(View.GONE);
                }
            });
        }
        else{

            view=(View)convertView;
        }

        return view;
    }
}
