package com.bakery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bakery.Bean.Navigation_Item_Bean;
import com.bakery.R;

import java.util.ArrayList;

/**
 * Created by system2 on 22-Dec-17.
 */

public class Navigation_Drawer_Adapter extends BaseAdapter {
    private ArrayList<Navigation_Item_Bean> arrayList;
    private Context context;

    public Navigation_Drawer_Adapter(Context context,ArrayList<Navigation_Item_Bean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {

        return arrayList.size();
    }

    @Override
    public Navigation_Item_Bean getItem(int pos) {

        return arrayList.get(pos);
    }

    @Override
    public long getItemId(int pos) {

        return pos;
    }

    @Override
    public View getView(final int pos, View view, ViewGroup parent) {
        ViewHolder holder = null;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.customview, parent, false);

            holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(R.id.title);
            holder.icon = (ImageView) view.findViewById(R.id.icon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();

        }

        holder.title.setText(arrayList.get(pos).getTitle());
        holder.icon.setBackgroundResource(arrayList.get(pos).getIcon());

        return view;
    }

    public class ViewHolder {
        TextView title;
        ImageView icon;
    }

}
