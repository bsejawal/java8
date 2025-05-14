package com.bsejawal.java8.stream;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Stream05ParallelStream{
  public static void main(String[] args) {
      List<Post> posts = fetchPosts();
      System.out.println(posts.size() +" \n" + posts);
  }


  public static List<Post> fetchPosts(){
      String url = "https://jsonplaceholder.typicode.com/posts";
      try {
      URL urlForGetRequest = new URL(url);
      String readLine = null;

          HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
          connection.setRequestMethod("GET");
          connection.setRequestProperty("urlid", "bsejawal");
          int responseCode = connection.getResponseCode();

          if (responseCode == HttpURLConnection.HTTP_OK) {
              BufferedReader in = new BufferedReader(
                      new InputStreamReader(connection.getInputStream())
              );
              StringBuffer response = new StringBuffer();
              while ((readLine = in.readLine()) != null) {
                  response.append(readLine);
              }
              in.close();
              ObjectMapper objectMapper = new ObjectMapper();
              try{
                  Post[] posts = objectMapper.readValue(response.toString(), Post[].class);
                  return Arrays.asList(posts);
              }catch (IOException e){
                  e.printStackTrace();
              }

          } else {
              System.out.println("GET NOT WORKED : responseCode = " + responseCode);

          }
      }catch(IOException e){
          System.err.println(e.getMessage());
      }
      return null;
  }
}

record Post(
     int userId,
     int id,
     String title,
     String body
){
}