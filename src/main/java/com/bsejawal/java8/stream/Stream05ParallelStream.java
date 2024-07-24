package com.bsejawal.java8.stream;
import com.google.gson.Gson;

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
      System.out.println(posts.size());


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
              Gson gson = new Gson();
              Post[] posts = gson.fromJson(response.toString(), Post[].class);
              return Arrays.asList(posts);
          } else {
              System.out.println("GET NOT WORKED : responseCode = " + responseCode);

          }
      }catch(IOException e){
          System.err.println(e.getMessage());
      }
      return null;
  }
}

class Post{
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}