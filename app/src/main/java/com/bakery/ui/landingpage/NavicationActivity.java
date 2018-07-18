package com.bakery.ui.landingpage;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bakery.Adapter.Navigation_Drawer_Adapter;
import com.bakery.Adapter.Navigation_Drawer_Categories_List_Adapter;
import com.bakery.Bean.CategoryBean;
import com.bakery.Bean.Navigation_Item_Bean;
import com.bakery.Fragment.Address_book_Fragment;
import com.bakery.Fragment.Fragment_Allcatecories;
import com.bakery.Fragment.Fragment_Item_List;
import com.bakery.Fragment.Fragment_Main;
import com.bakery.Fragment.MyAccountFragment;
import com.bakery.Fragment.RamConstants;
import com.bakery.R;
import com.bakery.Source.WebService;

import java.util.ArrayList;

/**
 * Created by system2 on 22-Dec-17.
 */

public class NavicationActivity extends FragmentActivity {
    ProgressDialog progressDialog;
    WebService webService;
    ListView navList1,navList2,navList3,navList4;
    private static ArrayList<Navigation_Item_Bean> arrayList2,arrayList3,arrayList4;
    private static Navigation_Drawer_Adapter adapter2,adapter3,adapter4;
    private static RelativeLayout left_slider;
    int pos1,pos2,pos3,pos4=0;
    android.support.v7.widget.Toolbar toolbar;
    ImageView logo_visib;
    TextView textView_visib;
    DrawerLayout drawer;
    LinearLayout header;
    final String[] fragments_home={"com.bakery.Fragment.Fragment_Main"};
    final String[] fragments1 ={"com.bakery.Fragment.Fragment_IceCream_Retail","com.bakery.Fragment.Fragment_Bakery_Retail"
            ,"com.bakery.Fragment.Fragment_Beverages_Retail" ,"com.bakery.Fragment.Fragment_IceCreamWholesale"
            ,"com.bakery.Fragment.Fragment_Bakery_Wholesale","com.bakery.Fragment.Fragment_BeveragesWholesale"};
    final String[] fragments2 ={};
    final String[] fragments3={"com.bakery.Fragment.Reorder_Fragment","com.bakery.Fragment.Wish_List_Fragment"
            ,"com.bakery.Fragment.MyOrder_Fragment","com.bakery.Fragment.MyAccountFragment",
            "com.bakery.Fragment.My_Product_Review_Fragment"};
    final String[] fragments4={"com.bakery.Fragment.Fragment_Help","com.bakery.Fragment.Fragment_About"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        RamConstants.buttonclick=0;
        progressDialog=new ProgressDialog(NavicationActivity.this,R.style.Dialog);
        progressDialog.setCanceledOnTouchOutside(false);
        new CategoriesAsy().execute();
        init();
        populateListItems();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        // default fragment
        fragment_main();
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.setDrawerListener( new DrawerLayout.SimpleDrawerListener(){
                    @Override
                    public void onDrawerClosed(View drawerView){

                            super.onDrawerClosed(drawerView);
                            fragment_main();
                    }
                });
                closeDrawer();
                list_item_background_color();
            }
        });

        //list 1
          navList1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,final int position,long id){
                pos1=position;
                RamConstants.buttonclick=0;
                // Navigation item background color change
                list_item1_background_color();
                drawer.setDrawerListener( new DrawerLayout.SimpleDrawerListener(){
                    @Override
                    public void onDrawerClosed(View drawerView){
                        if(RamConstants.buttonclick==0){
                            super.onDrawerClosed(drawerView);
                            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
                            tx.replace(R.id.main_fragment_layout, Fragment.instantiate(NavicationActivity.this,fragments1[position]));
                            tx.commit();
                        }
                        else {

                        }
                        }
                });
                closeDrawer();
            }
        });

        //list 2
        navList2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                pos2=position;
                // Navigation item background color change
                list_item2_background_color();
                drawer.setDrawerListener( new DrawerLayout.SimpleDrawerListener(){
                    @Override
                    public void onDrawerClosed(View drawerView){

                    }
                });
                closeDrawer();
            }
        });

        //list 3
        navList3.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                pos3=position;
                RamConstants.buttonclick=0;
                // Navigation item background color change
                list_item3_background_color();
                drawer.setDrawerListener( new DrawerLayout.SimpleDrawerListener(){
                    @Override
                    public void onDrawerClosed(View drawerView){
                        if(RamConstants.buttonclick==0){
                            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
                            tx.replace(R.id.main_fragment_layout, Fragment.instantiate(NavicationActivity.this,fragments3[position]));
                            tx.commit();
                        }
                        else {
                            //nothing
                        }
                    }
                });
                closeDrawer();
            }
        });
        //list 4

        navList4.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                pos4=position;
                RamConstants.buttonclick=0;
                // Navigation item background color change
                list_item4_background_color();
                drawer.setDrawerListener( new DrawerLayout.SimpleDrawerListener(){
                    @Override
                    public void onDrawerClosed(View drawerView){

                    }
                });
                closeDrawer();
            }
        });
        }

        void fragment_main(){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout,Fragment.instantiate(NavicationActivity.this,fragments_home[0]));
            tx.commit();
        }

        void init() {
        header=(LinearLayout)findViewById(R.id.header_view);
        toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        left_slider = (RelativeLayout) findViewById(R.id.slider);
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        navList1 = (ListView) findViewById(R.id.list1);
        navList2 = (ListView) findViewById(R.id.list2);
        navList3 = (ListView) findViewById(R.id.list3);
        navList4 = (ListView) findViewById(R.id.list4);
        logo_visib=(ImageView)findViewById(R.id.logo_visible);
        textView_visib=(TextView)findViewById(R.id.text_visible);
        arrayList2 = new ArrayList<Navigation_Item_Bean>();
        arrayList3 = new ArrayList<Navigation_Item_Bean>();
        arrayList4 = new ArrayList<Navigation_Item_Bean>();
    }

    class CategoriesAsy extends AsyncTask<String,Void,ArrayList<CategoryBean>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
            webService=new WebService();
        }

        @Override
        protected ArrayList<CategoryBean> doInBackground(String... params) {
            return webService.getCategories();
        }

        @Override
        protected void onPostExecute(final ArrayList<CategoryBean> list) {
            super.onPostExecute(list);
            progressDialog.dismiss();

            Navigation_Drawer_Categories_List_Adapter adapter=new Navigation_Drawer_Categories_List_Adapter(NavicationActivity.this,list);
            navList1.setAdapter(adapter);
        }


    }

    void closeDrawer() {
        if (drawer.isDrawerOpen(left_slider)) {
            drawer.closeDrawer(left_slider);
        }}

    // Populate navigation drawer listitems
    void populateListItems() {

        toolbar.setVisibility(View.VISIBLE);
        textView_visib.setVisibility(View.GONE);
        logo_visib.setVisibility(View.VISIBLE);

        //listview 2
        Integer Icons2[] = {R.mipmap.offer_icon,R.mipmap.notification};
        String title2[] = getResources().getStringArray(R.array.list_sub_item);



        for (int i = 0; i < Icons2.length; i++) {
            arrayList2.add(new Navigation_Item_Bean(title2[i],Icons2[i]));
        }
        adapter2 = new Navigation_Drawer_Adapter(NavicationActivity.this, arrayList2);
        //listview 3
        Integer Icons3[] = {R.mipmap.cart,R.mipmap.wishlist_icon,R.mipmap.my_order_icon
                ,R.mipmap.account_icon, R.mipmap.categories_icon};
        String title3[] = getResources().getStringArray(R.array.list_item_account);
        for (int i = 0; i < Icons3.length; i++) {
            arrayList3.add(new Navigation_Item_Bean(title3[i],Icons3[i]));
        }
        adapter3= new Navigation_Drawer_Adapter(NavicationActivity.this, arrayList3);
        //listview 4
        Integer Icons4[] = {R.mipmap.gift_icon,R.mipmap.store_icon,R.mipmap.help_center_icon
                ,R.mipmap.term_of_service_icon};
        String title4[] = getResources().getStringArray(R.array.list_item_help);

        for (int i = 0; i < Icons4.length; i++) {
            arrayList4.add(new Navigation_Item_Bean(title4[i],Icons4[i]));
        }
        adapter4 = new Navigation_Drawer_Adapter(NavicationActivity.this, arrayList4);
        // Set adapter
        navList2.setAdapter(adapter2);
        navList3.setAdapter(adapter3);
        navList4.setAdapter(adapter4);

        adapter2.notifyDataSetChanged();
        adapter3.notifyDataSetChanged();
        adapter4.notifyDataSetChanged();
    }

    void list_item1_background_color(){
        int i;
        switch (pos1){
            case 0:
                navList1.getChildAt(pos1).setBackgroundResource(R.color.colorGreen);
                for (i=1;i<=5;i++){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 1:
                navList1.getChildAt(pos1).setBackgroundResource(R.color.colorGreen);
                for (i=2;i<=5;i++){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                for (i=0;i>=0;i--){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 2:
                navList1.getChildAt(pos1).setBackgroundResource(R.color.colorGreen);
                for (i=3;i<=5;i++){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                for (i=1;i>=0;i--){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 3:
                navList1.getChildAt(pos1).setBackgroundResource(R.color.colorGreen);
                for (i=4;i<=5;i++){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                for (i=2;i>=0;i--){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 4:
                navList1.getChildAt(pos1).setBackgroundResource(R.color.colorGreen);
                for (i=5;i<=5;i++){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                for (i=3;i>=0;i--){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 5:
                navList1.getChildAt(pos1).setBackgroundResource(R.color.colorGreen);
                for (i=4;i>=0;i--){
                    navList1.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
        }
        for (int f=0;f<=1;f++){
            navList2.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=4;f++){
            navList3.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=3;f++){
            navList4.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
    }
    void list_item2_background_color(){
        int i;
        switch (pos2){
            case 0:
                navList2.getChildAt(pos2).setBackgroundResource(R.color.colorGreen);
                for (i=1;i<=1;i++){
                    navList2.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 1:
                navList2.getChildAt(pos2).setBackgroundResource(R.color.colorGreen);
                for (i=0;i>=0;i--){
                    navList2.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
        }
        for (int f=0;f<=5;f++){
            navList1.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=4;f++){
            navList3.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=3;f++){
            navList4.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
    }
    void list_item3_background_color(){
        int i;
        switch (pos3){
            case 0:
                navList3.getChildAt(pos3).setBackgroundResource(R.color.colorGreen);
                for (i=1;i<=4;i++){
                    navList3.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 1:
                navList3.getChildAt(pos3).setBackgroundResource(R.color.colorGreen);
                for (i=2;i<=4;i++){
                    navList3.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                for (i=0;i>=0;i--){
                    navList3.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 2:
                navList3.getChildAt(pos3).setBackgroundResource(R.color.colorGreen);
                for (i=3;i<=4;i++){
                    navList3.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                for (i=1;i>=0;i--){
                    navList3.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 3:
                navList3.getChildAt(pos3).setBackgroundResource(R.color.colorGreen);
                for (i=4;i<=4;i++){
                    navList3.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                for (i=2;i>=0;i--){
                    navList3.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 4:
                navList3.getChildAt(pos3).setBackgroundResource(R.color.colorGreen);
                for (i=3;i>=0;i--){
                    navList3.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
        }
        for (int f=0;f<=5;f++){
            navList1.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=1;f++){
            navList2.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=3;f++){
            navList4.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
    }
    void list_item4_background_color(){
        int i;
        switch (pos4){
            case 0:
                navList4.getChildAt(pos4).setBackgroundResource(R.color.colorGreen);
                for (i=1;i<=3;i++){
                    navList4.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 1:
                navList4.getChildAt(pos4).setBackgroundResource(R.color.colorGreen);
                for (i=2;i<=3;i++){
                    navList4.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                for (i=0;i>=0;i--){
                    navList4.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 2:
                navList4.getChildAt(pos4).setBackgroundResource(R.color.colorGreen);
                for (i=3;i<=3;i++){
                    navList4.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                for (i=1;i>=0;i--){
                    navList4.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
            case 3:
                navList4.getChildAt(pos4).setBackgroundResource(R.color.colorGreen);
                for (i=2;i>=0;i--){
                    navList4.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                break;
        }
        for (int f=0;f<=5;f++){
            navList1.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=1;f++){
            navList2.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=4;f++){
            navList3.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
    }
    void list_item_background_color(){
        for (int f=0;f<=5;f++){
            navList1.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=1;f++){
            navList2.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=4;f++){
            navList3.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
        for (int f=0;f<=3;f++){
            navList4.getChildAt(f).setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public void onBackPressed() {

        // Call whenBackpressed method to do task
        whenBackPressed();
    }
    void whenBackPressed() {
        if (drawer.isDrawerOpen(left_slider)) {
            drawer.closeDrawer(left_slider);
        }
        else if(RamConstants.buttonclick==1){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout,Fragment.instantiate(NavicationActivity.this, fragments1[0]));
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==2){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout,Fragment.instantiate(NavicationActivity.this, fragments1[1]));
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==3){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout,Fragment.instantiate(NavicationActivity.this, fragments1[2]));
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==4){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout,Fragment.instantiate(NavicationActivity.this, fragments1[3]));
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==5){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout,Fragment.instantiate(NavicationActivity.this, fragments1[4]));
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==6){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout,Fragment.instantiate(NavicationActivity.this, fragments1[5]));
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==7){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout,Fragment.instantiate(NavicationActivity.this, fragments3[2]));
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==8){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout,Fragment.instantiate(NavicationActivity.this, fragments3[3]));
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==9){
            Address_book_Fragment fragment = new Address_book_Fragment();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout, fragment);
            tx.commit();
            RamConstants.buttonclick=10;
        }
        else if(RamConstants.buttonclick==10){
            MyAccountFragment fragment = new MyAccountFragment();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout, fragment);
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==11){
            Fragment_Item_List fragment = new Fragment_Item_List();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout, fragment);
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==12){
            Fragment_Main fragment = new Fragment_Main();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout, fragment);
            tx.commit();
            RamConstants.buttonclick=16;
        }
        else if(RamConstants.buttonclick==13){
            Fragment_Allcatecories fragment = new Fragment_Allcatecories();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout, fragment);
            tx.commit();
            RamConstants.buttonclick=0;
        }
        else if(RamConstants.buttonclick==14){
            Fragment_Main fragment = new Fragment_Main();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout, fragment);
            tx.commit();
            RamConstants.buttonclick=16;
        }
        else if(RamConstants.buttonclick==15){
            Fragment_Main fragment = new Fragment_Main();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout, fragment);
            tx.commit();
            RamConstants.buttonclick=16;
        }
        else if(RamConstants.buttonclick==0){
            Fragment_Main fragment = new Fragment_Main();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.main_fragment_layout, fragment);
            tx.commit();
            RamConstants.buttonclick=16;
        }
        else {
            finish();
        }
    }
}


