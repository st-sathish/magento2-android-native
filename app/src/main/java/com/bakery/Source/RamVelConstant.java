package com.bakery.Source;

import com.bakery.Bean.ItemListBean;

import java.util.ArrayList;

/**
 * Created by system2 on 13-Feb-18.
 */

public class RamVelConstant {

    public static String TOKEN;


    public static String getTOKEN() {
        return TOKEN;
    }

    public static void setTOKEN(String TOKEN) {
        RamVelConstant.TOKEN = TOKEN;
    }

    public static ArrayList<ItemListBean> itemListBeans=new ArrayList<>();
}
