package com.bakery.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bakery.Adapter.MainMenuCategory1_Adapter;
import com.bakery.Bean.CategoryBean;
import com.bakery.R;
import com.bakery.Source.WebService;

import java.util.ArrayList;

/**
 * Created by system2 on 12-Jan-18.
 */

public class Fragment_Main extends Fragment {
    Toolbar toolbar;
    TextView text_visible;
    ImageView logo_visible;
    Button view_item,view_item2,view_item3,view_item4,view_item5,view_item6;
    WebService webService;
    ProgressDialog progressDialog;
    LinearLayout search_bar,all_catecories,all_item;
    GridView gridView_categories1,gridView_categories2,gridView_categories3,gridView_categories4,gridView_categories5,
            gridView_categories6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_main, container, false);

        progressDialog=new ProgressDialog(getActivity(),R.style.Dialog);
        progressDialog.setCanceledOnTouchOutside(false);
        view_item=(Button)view.findViewById(R.id.view_item);
        view_item2=(Button)view.findViewById(R.id.view_item2);
        view_item3=(Button)view.findViewById(R.id.view_item3);
        view_item4=(Button)view.findViewById(R.id.view_item4);
        view_item5=(Button)view.findViewById(R.id.view_item5);
        view_item6=(Button)view.findViewById(R.id.view_item6);

        all_catecories=(LinearLayout)view.findViewById(R.id.all_catecories);
        all_item=(LinearLayout)view.findViewById(R.id.all_item);
        search_bar=(LinearLayout)view.findViewById(R.id.search_bar);
        gridView_categories1 = (GridView) view.findViewById(R.id.grid_categories1);
        gridView_categories2 = (GridView) view.findViewById(R.id.grid_categories2);
        gridView_categories3 = (GridView) view.findViewById(R.id.grid_categories3);
        gridView_categories4 = (GridView) view.findViewById(R.id.grid_categories4);
        gridView_categories5 = (GridView) view.findViewById(R.id.grid_categories5);
        gridView_categories6 = (GridView) view.findViewById(R.id.grid_categories6);
        tool_set();
        new CategoriesAsy1().execute();
        new CategoriesAsy2().execute();
        new CategoriesAsy3().execute();
        new CategoriesAsy4().execute();
        new CategoriesAsy5().execute();
        new CategoriesAsy6().execute();

        view_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=7;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }

            }
        });
        view_item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=6;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }

            }
        });
        view_item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=22;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }

            }
        });
        view_item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=24;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }

            }
        });
        view_item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=26;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }

            }
        });
        view_item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=28;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }

            }
        });
        gridView_categories1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=7;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }
            }
        });
        gridView_categories2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=6;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }
            }
        });
        gridView_categories3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=22;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }
            }
        });
        gridView_categories4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=24;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }
            }
        });
        gridView_categories5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=26;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }
            }
        });
        gridView_categories6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=14;
                    RamConstants.changeid=28;
                    Fragment_Item_List fragment1 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment1);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }
            }
        });
        all_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected()==true )
                {
                    RamConstants.buttonclick=15;
                    Fragment_Item_List fragment2 = new Fragment_Item_List();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_layout, fragment2);
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Network Not Available",Toast.LENGTH_LONG).show();

                }


            }
        });
        search_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=14;
                Search_Fragment fragment2 = new Search_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment2);
                transaction.commit();
            }
        });

        all_catecories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RamConstants.buttonclick=14;
                Fragment_Allcatecories fragment3 = new Fragment_Allcatecories();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_layout, fragment3);
                transaction.commit();
            }
        });

        return view;

    }

    class CategoriesAsy1 extends AsyncTask<String,Void,ArrayList<CategoryBean>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            webService=new WebService();
        }

        @Override
        protected ArrayList<CategoryBean> doInBackground(String... params) {
            return webService.getCategory1();
        }

        @Override
        protected void onPostExecute(final ArrayList<CategoryBean> list) {
            super.onPostExecute(list);
            progressDialog.dismiss();

            MainMenuCategory1_Adapter adapt1 = new MainMenuCategory1_Adapter(getActivity(),list);
            gridView_categories1.setAdapter(adapt1);
        }
    }
    class CategoriesAsy2 extends AsyncTask<String,Void,ArrayList<CategoryBean>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            webService=new WebService();
        }

        @Override
        protected ArrayList<CategoryBean> doInBackground(String... params) {
            return webService.getCategory2();
        }

        @Override
        protected void onPostExecute(final ArrayList<CategoryBean> list) {
            super.onPostExecute(list);
            progressDialog.dismiss();

            MainMenuCategory1_Adapter adapt2 = new MainMenuCategory1_Adapter(getActivity(),list);
            gridView_categories2.setAdapter(adapt2);
        }
    }
    class CategoriesAsy3 extends AsyncTask<String,Void,ArrayList<CategoryBean>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            webService=new WebService();
        }

        @Override
        protected ArrayList<CategoryBean> doInBackground(String... params) {
            return webService.getCategory3();
        }

        @Override
        protected void onPostExecute(final ArrayList<CategoryBean> list) {
            super.onPostExecute(list);
            progressDialog.dismiss();

            MainMenuCategory1_Adapter adapt3 = new MainMenuCategory1_Adapter(getActivity(),list);
            gridView_categories3.setAdapter(adapt3);
        }
    }
    class CategoriesAsy4 extends AsyncTask<String,Void,ArrayList<CategoryBean>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            webService=new WebService();
        }

        @Override
        protected ArrayList<CategoryBean> doInBackground(String... params) {
            return webService.getCategory4();
        }

        @Override
        protected void onPostExecute(final ArrayList<CategoryBean> list) {
            super.onPostExecute(list);
            progressDialog.dismiss();

            MainMenuCategory1_Adapter adapt4 = new MainMenuCategory1_Adapter(getActivity(),list);
            gridView_categories4.setAdapter(adapt4);
        }
    }
    class CategoriesAsy5 extends AsyncTask<String,Void,ArrayList<CategoryBean>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            webService=new WebService();
        }

        @Override
        protected ArrayList<CategoryBean> doInBackground(String... params) {
            return webService.getCategory5();
        }

        @Override
        protected void onPostExecute(final ArrayList<CategoryBean> list) {
            super.onPostExecute(list);
            progressDialog.dismiss();

            MainMenuCategory1_Adapter adapt5 = new MainMenuCategory1_Adapter(getActivity(),list);
            gridView_categories5.setAdapter(adapt5);
        }
    }
    class CategoriesAsy6 extends AsyncTask<String,Void,ArrayList<CategoryBean>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            webService=new WebService();
        }

        @Override
        protected ArrayList<CategoryBean> doInBackground(String... params) {
            return webService.getCategory6();
        }

        @Override
        protected void onPostExecute(final ArrayList<CategoryBean> list) {
            super.onPostExecute(list);
            progressDialog.dismiss();

            MainMenuCategory1_Adapter adapt6 = new MainMenuCategory1_Adapter(getActivity(),list);
            gridView_categories6.setAdapter(adapt6);
        }
    }
    void tool_set(){
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        text_visible=(TextView)getActivity().findViewById(R.id.text_visible);
        logo_visible=(ImageView)getActivity().findViewById(R.id.logo_visible);
        logo_visible.setVisibility(View.VISIBLE);
        text_visible.setVisibility(View.GONE);
    }

}
