package com.bakery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.R;
import com.github.siyamed.shapeimageview.RoundedImageView;

/**
 * Created by system2 on 17-Feb-18.
 */

public class MainMenuListView1_Adapter extends BaseAdapter {
    private int[] image=null;
    Context context;

    public MainMenuListView1_Adapter(Context context, int[] image) {
        this.context=context;
        this.image=image;
    }

    @Override
    public int getCount() {
        return image.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            view =new View(context);
            view=inflater.inflate(R.layout.main_category_list_item,null);
            RoundedImageView imageView=(RoundedImageView)view.findViewById(R.id.list_image);
            imageView.setImageResource(image[position]);
        }
        else{

            view=(View)convertView;
        }

        return view;
    }
}
