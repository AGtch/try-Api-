package com.example.apiretrofitwithrxjava.data;

import com.example.apiretrofitwithrxjava.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static PostClient postClientInstance;
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostClient getPostClientInstance() {
        if (postClientInstance == null)
            postClientInstance = new PostClient();
        return postClientInstance;
    }

    public  Call<List<PostModel>>  getPosts() {
        return postInterface.getPosts();
    }
}
