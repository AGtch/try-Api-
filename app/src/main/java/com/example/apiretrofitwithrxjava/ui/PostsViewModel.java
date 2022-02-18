package com.example.apiretrofitwithrxjava.ui;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apiretrofitwithrxjava.data.PostClient;
import com.example.apiretrofitwithrxjava.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> error = new MutableLiveData<>();

    public void getPosts() {
        PostClient.getPostClientInstance().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                error.setValue(t.getMessage());
            }
        });
    }
}

