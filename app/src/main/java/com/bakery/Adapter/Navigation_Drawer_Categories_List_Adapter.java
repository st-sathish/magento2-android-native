package com.bakery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.Bean.CategoryBean;
import com.bakery.Bean.Navigation_Item_Bean;
import com.bakery.R;

import java.util.ArrayList;

/**
 * Created by system2 on 14-Feb-18.
 */

public class Navigation_Drawer_Categories_List_Adapter extends BaseAdapter {
    ArrayList<CategoryBean> list;
    TextView names;
    ImageView icon;
    Context context;

    public  Navigation_Drawer_Categories_List_Adapter(Context context, ArrayList<CategoryBean> list) {
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
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            view=new View(context);
            view=inflater.inflate(R.layout.customview,null);
            names=(TextView)view.findViewById(R.id.title);
            icon=(ImageView)view.findViewById(R.id.icon);
            icon.setImageResource(R.mipmap.ice_retail_icon);
            names.setText(list.get(position).getName());
            }
        else{
            view=(View)convertView;
        }
        return view;

    }
}