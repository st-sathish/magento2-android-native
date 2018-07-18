package com.bakery.Source;

import android.os.Build;
import android.util.Log;
import android.widget.ImageView;

import com.bakery.Bean.CategoryBean;
import com.bakery.Bean.HomeBean;
import com.bakery.Bean.ItemListBean;
import com.bakery.Fragment.RamConstants;
import com.bakery.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by system2 on 02-Feb-18.
 */

public class WebService {
    JSONParser jsonParser;
    JSONArray jsonArray,jsonArray2;
    public WebService() {
        jsonParser=new JSONParser();
    }
  /*  public ArrayList<HomeBean> getDoctorList(){

        ArrayList<HomeBean> list=new ArrayList<>();
        String url=Config.URL+"rest/default/V1/categories";
        try {
            JSONObject postDataParams = new JSONObject();
            postDataParams.put("bearer","x0ls3f00cbpc790uxowq9okni1dell1e");
            String param="username=democheck&password=1qaz0okm";
            JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url,param));
            Log.d("url",url);
            Log.d("postDataParams",postDataParams.toString());
            Log.d("postDataParams",jsonObject.toString());
            jsonArray=jsonObject.getJSONArray("doctors");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                HomeBean bean=new HomeBean();
                bean.setId(jsonArrayJSONObject.getInt("doctor_id"));
                bean.setName(jsonArrayJSONObject.getString("name"));

                list.add(bean);

            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }*/


    public ArrayList<CategoryBean> getCategories(){

        ArrayList<CategoryBean> list=new ArrayList<>();
        String url=Config.URL+"rest/default/V1/categories";
        try {

            JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url));
           System.out.print(jsonObject.toString());
            jsonArray=jsonObject.getJSONArray("children_data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                CategoryBean bean=new CategoryBean();
                bean.setId(jsonArrayJSONObject.getInt("id"));
                bean.setName(jsonArrayJSONObject.getString("name"));

              /*  JSONObject subcatobj=new JSONObject(jsonArrayJSONObject.getString("children_data"));
                JSONArray subCatArray=subcatobj.getJSONArray("children_data");
                for (i = 0; i < subCatArray.length(); i++) {
                    JSONObject jsonsubArrCatObj = subCatArray.getJSONObject(i);
                    System.out.println(jsonsubArrCatObj.getString("name"));
                }*/
                list.add(bean);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<CategoryBean> getCategory1(){

        ArrayList<CategoryBean> list=new ArrayList<>();
        String url="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=7searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=4&searchCriteria[currentPage]=1";
        try {
                JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url));
                //System.out.print(jsonObject.toString());
                jsonArray=jsonObject.getJSONArray("items");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                    CategoryBean bean=new CategoryBean();
                    bean.setName(jsonArrayJSONObject.getString("name"));
                    bean.setPrice(jsonArrayJSONObject.getString("price"));
                    jsonArray2=jsonArrayJSONObject.getJSONArray("custom_attributes");
                    System.out.println(jsonArray2.toString());
                    for (int j = 0; j < jsonArray2.length(); j++) {
                        JSONObject jsonArrayObject = jsonArray2.getJSONObject(j);

                        if(j==2){
                            bean.setImage(jsonArrayObject.getString("value"));
                        }
                    }
                    String image=Config.IMAGE_URL+bean.getImage();
                    bean.setImage(image);
                    list.add(bean);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<CategoryBean> getCategory2(){

        ArrayList<CategoryBean> list=new ArrayList<>();
        String url="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=6searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=4&searchCriteria[currentPage]=1";
        try {
            JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url));
            //System.out.print(jsonObject.toString());
            jsonArray=jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                CategoryBean bean=new CategoryBean();
                bean.setName(jsonArrayJSONObject.getString("name"));
                bean.setPrice(jsonArrayJSONObject.getString("price"));
                jsonArray2=jsonArrayJSONObject.getJSONArray("custom_attributes");
                System.out.println(jsonArray2.toString());
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonArrayObject = jsonArray2.getJSONObject(j);

                    if(j==2){
                        bean.setImage(jsonArrayObject.getString("value"));
                    }
                }
                String image=Config.IMAGE_URL+bean.getImage();
                bean.setImage(image);
                list.add(bean);
        }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<CategoryBean> getCategory3(){

        ArrayList<CategoryBean> list=new ArrayList<>();
        String url="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=22searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=4&searchCriteria[currentPage]=1";
        try {
            JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url));
            //System.out.print(jsonObject.toString());
            jsonArray=jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                CategoryBean bean=new CategoryBean();
                bean.setName(jsonArrayJSONObject.getString("name"));
                bean.setPrice(jsonArrayJSONObject.getString("price"));
                jsonArray2=jsonArrayJSONObject.getJSONArray("custom_attributes");
                System.out.println(jsonArray2.toString());
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonArrayObject = jsonArray2.getJSONObject(j);

                    if(j==2){
                        bean.setImage(jsonArrayObject.getString("value"));
                    }
                }
                String image=Config.IMAGE_URL+bean.getImage();
                bean.setImage(image);
                list.add(bean);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<CategoryBean> getCategory4(){

        ArrayList<CategoryBean> list=new ArrayList<>();
        String url="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=24searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=4&searchCriteria[currentPage]=1";
        try {
            JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url));
            //System.out.print(jsonObject.toString());
            jsonArray=jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                CategoryBean bean=new CategoryBean();
                bean.setName(jsonArrayJSONObject.getString("name"));
                bean.setPrice(jsonArrayJSONObject.getString("price"));
                jsonArray2=jsonArrayJSONObject.getJSONArray("custom_attributes");
                System.out.println(jsonArray2.toString());
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonArrayObject = jsonArray2.getJSONObject(j);

                    if(j==2){
                        bean.setImage(jsonArrayObject.getString("value"));
                    }
                }
                String image=Config.IMAGE_URL+bean.getImage();
                bean.setImage(image);
                list.add(bean);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<CategoryBean> getCategory5(){

        ArrayList<CategoryBean> list=new ArrayList<>();
        String url="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=26searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=4&searchCriteria[currentPage]=1";
        try {
            JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url));
            //System.out.print(jsonObject.toString());
            jsonArray=jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                CategoryBean bean=new CategoryBean();
                bean.setName(jsonArrayJSONObject.getString("name"));
                bean.setPrice(jsonArrayJSONObject.getString("price"));
                jsonArray2=jsonArrayJSONObject.getJSONArray("custom_attributes");
                System.out.println(jsonArray2.toString());
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonArrayObject = jsonArray2.getJSONObject(j);

                    if(j==2){
                        bean.setImage(jsonArrayObject.getString("value"));
                    }
                }
                String image=Config.IMAGE_URL+bean.getImage();
                bean.setImage(image);
                list.add(bean);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<CategoryBean> getCategory6(){

        ArrayList<CategoryBean> list=new ArrayList<>();
        String url="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=28searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=4&searchCriteria[currentPage]=1";
        try {
            JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url));
            //System.out.print(jsonObject.toString());
            jsonArray=jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                CategoryBean bean=new CategoryBean();
                bean.setName(jsonArrayJSONObject.getString("name"));
                bean.setPrice(jsonArrayJSONObject.getString("price"));
                jsonArray2=jsonArrayJSONObject.getJSONArray("custom_attributes");
                System.out.println(jsonArray2.toString());
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonArrayObject = jsonArray2.getJSONObject(j);

                    if(j==2){
                        bean.setImage(jsonArrayObject.getString("value"));
                    }
                }
                String image=Config.IMAGE_URL+bean.getImage();
                bean.setImage(image);
                list.add(bean);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    //Item List
    public ArrayList<ItemListBean> product_itemlist(){

        ArrayList<ItemListBean> list=new ArrayList<>();
        String url="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=7searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=50&searchCriteria[currentPage]=1";
        String url2="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=6searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=50&searchCriteria[currentPage]=1";
        String url3="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=22searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=50&searchCriteria[currentPage]=1";
        String url4="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=24searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=50&searchCriteria[currentPage]=1";
        String url5="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=26searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=50&searchCriteria[currentPage]=1";
        String url6="http://uat.ramveltraders.com/rest/V1/products?searchCriteria[filterGroups][0][filters][0][field]=category_id&searchCriteria[filterGroups][0][filters][0][value]=28searchCriteria[filterGroups][0][filters][0][conditionType]=eq&searchCriteria[sortOrders][0][field]=created_at&searchCriteria[sortOrders][0][direction]=DESC&searchCriteria[pageSize]=50&searchCriteria[currentPage]=1";

        try {
            if (RamConstants.changeid==7){
                JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url));
                //System.out.print(jsonObject.toString());
                jsonArray=jsonObject.getJSONArray("items");
            }
            else if(RamConstants.changeid==6){
                JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url2));
                //System.out.print(jsonObject.toString());
                jsonArray=jsonObject.getJSONArray("items");
            }
            else if(RamConstants.changeid==22){
                JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url3));
                //System.out.print(jsonObject.toString());
                jsonArray=jsonObject.getJSONArray("items");
            }
            else if(RamConstants.changeid==24){
                JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url4));
                //System.out.print(jsonObject.toString());
                jsonArray=jsonObject.getJSONArray("items");
            }
            else if(RamConstants.changeid==26){
                JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url5));
                //System.out.print(jsonObject.toString());
                jsonArray=jsonObject.getJSONArray("items");
            }
            else if(RamConstants.changeid==28){
                JSONObject jsonObject=new JSONObject(jsonParser.sendGET(url6));
                //System.out.print(jsonObject.toString());
                jsonArray=jsonObject.getJSONArray("items");
            }
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                ItemListBean bean=new ItemListBean();
                bean.setName(jsonArrayJSONObject.getString("name"));
                bean.setPrice(jsonArrayJSONObject.getString("price"));
                jsonArray2=jsonArrayJSONObject.getJSONArray("custom_attributes");
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonArrayObject = jsonArray2.getJSONObject(j);
                    if(j==0){
                        bean.setDiscription(jsonArrayObject.getString("value"));
                    }
                    if(j==2){
                        bean.setImage(jsonArrayObject.getString("value"));
                    }
                    if (j==3){
                        bean.setSmall_image(jsonArrayObject.getString("value"));
                    }
                    if (j==4){
                        bean.setThumbnail(jsonArrayObject.getString("value"));
                    }
                    if (j==10){
                        bean.setSwatch_image(jsonArrayObject.getString("value"));
                    }
                }
                String image=Config.IMAGE_URL+bean.getImage();
                String small_image=Config.IMAGE_URL+bean.getSmall_image();
                String thumnail=Config.IMAGE_URL+bean.getThumbnail();
                String swath_image=Config.IMAGE_URL+bean.getSwatch_image();
                bean.setImage(image);
                bean.setSmall_image(small_image);
                bean.setThumbnail(thumnail);
                bean.setSwatch_image(swath_image);
                list.add(bean);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
  /*  public ArrayList<ItemListBean> get_product_item_List(){


        ArrayList<ItemListBean> list=new ArrayList<>();
        String urls=Config.URL+"rest/V1/products?searchCriteria[pageSize]=10";
        try {
            JSONObject jsonObject=new JSONObject(jsonParser.sendGET(urls));
            //System.out.print(jsonObject.toString());
            jsonArray=jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                ItemListBean bean=new ItemListBean();
                bean.setName(jsonArrayJSONObject.getString("name"));
                bean.setPrice(jsonArrayJSONObject.getString("price"));
                jsonArray2=jsonArrayJSONObject.getJSONArray("custom_attributes");
                System.out.println(jsonArray2.toString());
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonArrayObject = jsonArray2.getJSONObject(j);
                    if(j==0){
                        bean.setDiscription(jsonArrayObject.getString("value"));
                    }
                    if(j==2){
                        bean.setImage(jsonArrayObject.getString("value"));
                    }
                    if (j==3){
                        bean.setSmall_image(jsonArrayObject.getString("value"));
                    }
                    if (j==4){
                        bean.setThumbnail(jsonArrayObject.getString("value"));
                    }
                    if (j==10){
                        bean.setSwatch_image(jsonArrayObject.getString("value"));
                    }
                    //System.out.println("********"+jsonArrayObject.getString("attribute_code"));
                   // System.out.println("********"+jsonArrayObject.getString("value"));
                }
                String image=Config.IMAGE_URL+bean.getImage();
                String small_image=Config.IMAGE_URL+bean.getSmall_image();
                String thumnail=Config.IMAGE_URL+bean.getThumbnail();
                String swath_image=Config.IMAGE_URL+bean.getSwatch_image();
                bean.setImage(image);
                bean.setSmall_image(small_image);
                bean.setThumbnail(thumnail);
                bean.setSwatch_image(swath_image);
                list.add(bean);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<ItemListBean> get_product_item_Grid(){


        ArrayList<ItemListBean> list=new ArrayList<>();
        String urls=Config.URL+"rest/V1/products?searchCriteria[pageSize]=10";
        try {
            JSONObject jsonObject=new JSONObject(jsonParser.sendGET(urls));
            //System.out.print(jsonObject.toString());
            jsonArray=jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                ItemListBean bean=new ItemListBean();
                bean.setName(jsonArrayJSONObject.getString("name"));
                bean.setPrice(jsonArrayJSONObject.getString("price"));
                jsonArray2=jsonArrayJSONObject.getJSONArray("custom_attributes");
                System.out.println(jsonArray2.toString());
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonArrayObject = jsonArray2.getJSONObject(j);
                    if(j==0){
                        bean.setDiscription(jsonArrayObject.getString("value"));
                    }
                    if(j==2){
                        bean.setImage(jsonArrayObject.getString("value"));
                    }
                    if (j==3){
                        bean.setSmall_image(jsonArrayObject.getString("value"));
                    }
                    if (j==4){
                        bean.setThumbnail(jsonArrayObject.getString("value"));
                    }
                    if (j==10){
                        bean.setSwatch_image(jsonArrayObject.getString("value"));
                    }
                    //System.out.println("********"+jsonArrayObject.getString("attribute_code"));
                    // System.out.println("********"+jsonArrayObject.getString("value"));
                }
                String image=Config.IMAGE_URL+bean.getImage();
                String small_image=Config.IMAGE_URL+bean.getSmall_image();
                String thumnail=Config.IMAGE_URL+bean.getThumbnail();
                String swath_image=Config.IMAGE_URL+bean.getSwatch_image();
                bean.setImage(image);
                bean.setSmall_image(small_image);
                bean.setThumbnail(thumnail);
                bean.setSwatch_image(swath_image);
                list.add(bean);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }*/
}

