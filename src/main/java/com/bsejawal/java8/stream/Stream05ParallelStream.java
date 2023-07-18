package com.bsejawal.java8.stream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Stream05ParallelStream{
  public static void main(String[] args) IOException{
    String url = "https://jsonplaceholder.typicode.com/posts";
        URL urlForGetRequest = new URL(url);
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("urlid", "bsejawal");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            StringBuffer response = new StringBuffer();
            while((readLine = in.readLine()) != null){
                response.append(readLine);
            }
            in.close();
            System.out.println("JSON String Result: "+ response.toString());
        }else{
            System.out.println("GET NOT WORKED : responseCode = " + responseCode);
        }
    
  } 
}
