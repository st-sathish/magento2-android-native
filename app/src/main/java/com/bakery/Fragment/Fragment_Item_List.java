package com.bakery.Fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bakery.Adapter.Product_Item_GridView_Adapter;
import com.bakery.Adapter.Product_Item_ListView_Adapter;
import com.bakery.Bean.ItemListBean;
import com.bakery.R;
import com.bakery.Source.RamVelConstant;
import com.bakery.Source.WebService;

import java.util.ArrayList;

/**
 * Created by system2 on 14-Feb-18.
 */

public class Fragment_Item_List extends Fragment {
    GridView gridView;
    ListView listView;
    Toolbar toolbar;
    boolean click = true;
    WebService webService;
    ImageView list, grid, search_back;
    ProgressDialog progressDialog;
    View sheetView;
    LinearLayout list_grid_image;
    LinearLayout buttom1, buttom2, buttom3, buttom4, buttom5;
    BottomSheetDialog mBottomSheetDialog;
    LinearLayout layout_sort, layout_filter;
    ImageView in1, in2, in3, in4, in5, out1, out2, out3, out4, out5;
    boolean one = true;
    boolean two = true;
    boolean three = true;
    boolean four = true;
    boolean five = true;
    int getId;

    ArrayList<ItemListBean> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        mBottomSheetDialog = new BottomSheetDialog(getActivity());
        sheetView = getActivity().getLayoutInflater().inflate(R.layout.buttom_sheet_dialog, null);
        mBottomSheetDialog.setContentView(sheetView);
        progressDialog = new ProgressDialog(getActivity(), R.style.Dialog);
        progressDialog.setCanceledOnTouchOutside(false);
        buttom1 = (LinearLayout) sheetView.findViewById(R.id.bottom_sheet1);
        buttom2 = (LinearLayout) sheetView.findViewById(R.id.bottom_sheet2);
        buttom3 = (LinearLayout) sheetView.findViewById(R.id.bottom_sheet3);
        buttom4 = (LinearLayout) sheetView.findViewById(R.id.bottom_sheet4);
        buttom5 = (LinearLayout) sheetView.findViewById(R.id.bottom_sheet5);
        in1 = (ImageView) sheetView.findViewById(R.id.radio_in1);
        in2 = (ImageView) sheetView.findViewById(R.id.radio_in2);
        in3 = (ImageView) sheetView.findViewById(R.id.radio_in3);
        in4 = (ImageView) sheetView.findViewById(R.id.radio_in4);
        in5 = (ImageView) sheetView.findViewById(R.id.radio_in5);
        out1 = (ImageView) sheetView.findViewById(R.id.radio_out1);
        out2 = (ImageView) sheetView.findViewById(R.id.radio_out2);
        out3 = (ImageView) sheetView.findViewById(R.id.radio_out3);
        out4 = (ImageView) sheetView.findViewById(R.id.radio_out4);
        out5 = (ImageView) sheetView.findViewById(R.id.radio_out5);

        list = (ImageView) view.findViewById(R.id.list);
        grid = (ImageView) view.findViewById(R.id.gird);
        search_back = (ImageView) view.findViewById(R.id.search_back);
        list_grid_image = (LinearLayout) view.findViewById(R.id.list_grid_icon);
        layout_sort = (LinearLayout) view.findViewById(R.id.layout_sort);
        layout_filter = (LinearLayout) view.findViewById(R.id.layout_filter);
        gridView = (GridView) view.findViewById(R.id.grid_view);
        listView = (ListView) view.findViewById(R.id.list_view);

        new ItemListAsyList().execute();

        list_grid_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click == true) {
                    gridView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    list.setVisibility(View.GONE);
                    grid.setVisibility(View.VISIBLE);
                    click = false;
                } else {
                    listView.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.GONE);
                    list.setVisibility(View.VISIBLE);
                    grid.setVisibility(View.GONE);
                    click = true;
                }
            }
        });

        buttom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (one == true) {
                    out1.setBackgroundResource(R.mipmap.radio_out_icon);
                    in1.setVisibility(View.VISIBLE);
                    one = false;
                } else {
                    in1.setVisibility(View.GONE);
                    out1.setBackgroundResource(R.mipmap.radio_gray_icon);
                    one = true;
                }
                out2.setBackgroundResource(R.mipmap.radio_gray_icon);
                out3.setBackgroundResource(R.mipmap.radio_gray_icon);
                out4.setBackgroundResource(R.mipmap.radio_gray_icon);
                out5.setBackgroundResource(R.mipmap.radio_gray_icon);
                in2.setVisibility(View.GONE);
                in3.setVisibility(View.GONE);
                in4.setVisibility(View.GONE);
                in5.setVisibility(View.GONE);
                mBottomSheetDialog.hide();
            }
        });

        buttom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (two == true) {
                    out2.setBackgroundResource(R.mipmap.radio_out_icon);
                    in2.setVisibility(View.VISIBLE);
                    two = false;
                } else {
                    in2.setVisibility(View.GONE);
                    out2.setBackgroundResource(R.mipmap.radio_gray_icon);
                    two = true;
                }
                out3.setBackgroundResource(R.mipmap.radio_gray_icon);
                out1.setBackgroundResource(R.mipmap.radio_gray_icon);
                out4.setBackgroundResource(R.mipmap.radio_gray_icon);
                out5.setBackgroundResource(R.mipmap.radio_gray_icon);
                in1.setVisibility(View.GONE);
                in3.setVisibility(View.GONE);
                in4.setVisibility(View.GONE);
                in5.setVisibility(View.GONE);
                mBottomSheetDialog.hide();
            }
        });
        buttom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (three == true) {
                    out3.setBackgroundResource(R.mipmap.radio_out_icon);
                    in3.setVisibility(View.VISIBLE);
                    three = false;
                } else {
                    out3.setBackgroundResource(R.mipmap.radio_gray_icon);
                    in3.setVisibility(View.GONE);
                    three = true;
                }
                out2.setBackgroundResource(R.mipmap.radio_gray_icon);
                out1.setBackgroundResource(R.mipmap.radio_gray_icon);
                out4.setBackgroundResource(R.mipmap.radio_gray_icon);
                out5.setBackgroundResource(R.mipmap.radio_gray_icon);
                in2.setVisibility(View.GONE);
                in1.setVisibility(View.GONE);
                in4.setVisibility(View.GONE);
                in5.setVisibility(View.GONE);
                mBottomSheetDialog.hide();
            }
        });

        buttom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (four == true) {
                    out4.setBackgroundResource(R.mipmap.radio_out_icon);
                    in4.setVisibility(View.VISIBLE);
                    four = false;
                } else {
                    out4.setBackgroundResource(R.mipmap.radio_gray_icon);
                    in4.setVisibility(View.GONE);
                    four = true;
                }
                out3.setBackgroundResource(R.mipmap.radio_gray_icon);
                out1.setBackgroundResource(R.mipmap.radio_gray_icon);
                out2.setBackgroundResource(R.mipmap.radio_gray_icon);
                out5.setBackgroundResource(R.mipmap.radio_gray_icon);
                in2.setVisibility(View.GONE);
                in3.setVisibility(View.GONE);
                in1.setVisibility(View.GONE);
                in5.setVisibility(View.GONE);
                mBottomSheetDialog.hide();
            }
        });
        buttom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (five == true) {
                    out5.setBackgroundResource(R.mipmap.radio_out_icon);
                    in5.setVisibility(View.VISIBLE);
                    five = false;
                } else {
                    out5.setBackgroundResource(R.mipmap.radio_gray_icon);
                    in5.setVisibility(View.GONE);
                    five = true;
                }
                out3.setBackgroundResource(R.mipmap.radio_gray_icon);
                out1.setBackgroundResource(R.mipmap.radio_gray_icon);
                out4.setBackgroundResource(R.mipmap.radio_gray_icon);
                out2.setBackgroundResource(R.mipmap.radio_gray_icon);
                in2.setVisibility(View.GONE);
                in3.setVisibility(View.GONE);
                in4.setVisibility(View.GONE);
                in1.setVisibility(View.GONE);
                mBottomSheetDialog.hide();
            }
        });
        search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick = 12;
                Fragment_Allcatecories fragment = new Fragment_Allcatecories();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        layout_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.show();
            }
        });

        layout_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick = 11;
                Fragment_filter fragment = new Fragment_filter();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RamConstants.buttonclick = 11;
                Item_Detail_Fragment fragment = new Item_Detail_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("pos",position);
                fragment.setArguments(bundle);
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RamConstants.buttonclick = 11;
                Item_Detail_Fragment fragment = new Item_Detail_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("pos",position);
                fragment.setArguments(bundle);
                transaction.replace(R.id.main_fragment_layout, fragment);
                transaction.commit();
            }
        });
        return view;
    }

    class ItemListAsyList extends AsyncTask<String, Void, ArrayList<ItemListBean>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            webService = new WebService();
        }

        @Override
        protected ArrayList<ItemListBean> doInBackground(String... params) {
            return webService.product_itemlist();
        }

        @Override
        protected void onPostExecute(final ArrayList<ItemListBean> list) {
            super.onPostExecute(list);
            progressDialog.dismiss();
            arrayList=list;
            RamVelConstant.itemListBeans=list;
            Product_Item_ListView_Adapter adapt2 = new Product_Item_ListView_Adapter(getActivity(),list);
            listView.setAdapter(adapt2);
        }
    }
}