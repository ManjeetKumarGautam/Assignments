package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        String link = "https://api.chucknorris.io/jokes/random";

        URL url = null;
        HttpURLConnection conn = null;
        int responseCode = 0;

        try{
            url = new URL(link);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // connection
        try{
            conn = (HttpURLConnection) url.openConnection();
            responseCode = conn.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // extract information
        if(responseCode==200){
            BufferedReader data=new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder apiData = new StringBuilder();
            String readLine = null;

            while ((readLine = data.readLine())!=null){
                apiData.append(readLine);
            }

            try{
                data.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

//            System.out.println(apiData.toString());

            JSONObject apiResponse=new JSONObject(apiData.toString());
            System.out.println(apiResponse.get("categories"));
            System.out.println(apiResponse.get("created_at"));
            System.out.println(apiResponse.get("icon_url"));
            System.out.println(apiResponse.get("id"));
            System.out.println(apiResponse.get("updated_at"));
            System.out.println(apiResponse.get("url"));
            System.out.println(apiResponse.get("value"));


        }
        else{
            System.out.println("API call could not be made!!!");
        }

    }
}