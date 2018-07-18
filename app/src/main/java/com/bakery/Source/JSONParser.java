package com.bakery.Source;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Mafiree on 10/4/2016.
 */

public class JSONParser {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    HttpURLConnection urlConnection;

    public String parseGET(String GET_URL){

        StringBuilder result = new StringBuilder();
        try {
            // URL url = new URL("https://api.github.com/users/dmnugent80/repos");
            URL url = new URL(GET_URL);
            urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode = urlConnection.getResponseCode();
            //urlConnection.set
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        }catch( Exception e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }

        return result.toString();
    }


    public String sendGET(String POST_URL) throws IOException {
        String result=null;
        StringBuffer response=null;
        String USER_AGENT = "Mozilla/5.0";
        String token="7vya2dwdmxrjf94d38j2v9s4qaw4b7l3";
        //    String POST_URL = "http://ss.urbansoftusa.com/api/authenticate";

        //   String POST_PARAMS = "email=issac@mirutechnologies.com&password=123456";

        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Bearer", token);
      /*  // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        // For POST only - END*/

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //      Toast.makeText(getApplicationContext(),"response: "+response.toString(),Toast.LENGTH_LONG).show();
            Log.d("response",response.toString());
            // print result
            System.out.println(response.toString());
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getErrorStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            System.out.println("POST request not worked");
        }


        if(responseCode==200)
            result=response.toString();
        else
        if(responseCode==400 || responseCode==401)
            result=response.toString();
        else
            result=result;

        return result;
    }


    public String sendPost(String POST_URL,String POST_PARAMS) throws IOException {
        /*String result=null;
        StringBuffer response=null;
        String USER_AGENT = "Mozilla/5.0";
        String token="7vya2dwdmxrjf94d38j2v9s4qaw4b7l3";
        //    String POST_URL = "http://ss.urbansoftusa.com/api/authenticate";

        //   String POST_PARAMS = "email=issac@mirutechnologies.com&password=123456";

        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);

        con.setRequestProperty("Content-Type", "application/json");


       // con.setRequestProperty("Bearer", token);
        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //      Toast.makeText(getApplicationContext(),"response: "+response.toString(),Toast.LENGTH_LONG).show();
            Log.d("response",response.toString());
            // print result
            System.out.println(response.toString());
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getErrorStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            System.out.println("POST request not worked");
        }


        if(responseCode==200)
            result=response.toString();
        else
        if(responseCode==400 || responseCode==401)
            result=response.toString();
        else
            result=result;

        return result;*/


        String result=null;
        StringBuffer response=null;
        String USER_AGENT = "Mozilla/5.0";
        //    String POST_URL = "http://ss.urbansoftusa.com/api/authenticate";

        //   String POST_PARAMS = "email=issac@mirutechnologies.com&password=123456";

        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", "application/json");
        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //      Toast.makeText(getApplicationContext(),"response: "+response.toString(),Toast.LENGTH_LONG).show();
            Log.d("response",response.toString());
            // print result
            System.out.println(response.toString());
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getErrorStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            System.out.println("POST request not worked");
        }


        if(responseCode==200)
            result=response.toString();
        else
        if(responseCode==400 || responseCode==401)
            result=response.toString();
        else
            result=result;

        return result;
    }

    /*public String getToken(){

        try {


            URL myURL = new URL(serviceURL);
            HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();
            String userCredentials = "username:password";
            String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
            myURLConnection.setRequestProperty("Authorization", basicAuth);
            myURLConnection.setRequestMethod("POST");
            myURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            myURLConnection.setRequestProperty("Content-Length", "" + postData.getBytes().length);
            myURLConnection.setRequestProperty("Content-Language", "en-US");
            myURLConnection.setUseCaches(false);
            myURLConnection.setDoInput(true);
            myURLConnection.setDoOutput(true);

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return
    }*/


    public String sendPostRequest(String urlPost) {

        try {

            URL url = new URL(urlPost); // here is your URL path

            JSONObject postDataParams = new JSONObject();
            postDataParams.put("username", "democheck");
            postDataParams.put("password", "1qaz0okm");
            Log.e("params",postDataParams.toString());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            // writer.write(getPostDataString(params));

            //for direct json obect
            writer.write(postDataParams.toString());

            writer.flush();
            writer.close();
            os.close();

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(new
                        InputStreamReader(
                        conn.getInputStream()));

                StringBuffer sb = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {

                    sb.append(line);
                    break;
                }

                in.close();
                System.out.print("*****result*******"+responseCode);
                System.out.print("*****result*******"+sb.toString());
                return sb.toString();



            } else {
                return new String("false : " + responseCode);
            }
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

}

//http://www.oodlestechnologies.com/blogs/Sending-http-request-%7C-Post-String-data-%28-JSON-%29-%7C-with-authentication