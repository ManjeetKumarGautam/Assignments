package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class StudentAPI {


    public String getData() throws IOException{

        String str="";
        String link= "http://localhost:8080/student";

        URL url = null;
        HttpURLConnection conn = null;
        int responseCode = 0;


        try {
            url = new URL(link);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
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

            System.out.println(apiData.toString());
            str=apiData.toString();
        }
        else{
            System.out.println("API call could not be made!!!");
        }
        return str;
    }
}
