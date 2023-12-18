package com.example.myapplication;

import com.example.myapplication.model.DataJson;
import com.example.myapplication.model.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("dd-MM-yyyy")
            .create();
    ApiService apiService = new Retrofit.Builder()
//            .baseUrl("https://jsonplaceholder.typicode.com/")
            .baseUrl("https://dummy.restapiexample.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

//    @GET("posts")
//    Call<List<Item>> getListItems(
////            tùy api
////            @Query("userId") int userId
//    );
    @GET("employees")
    Call<DataJson<Item>> getListItems();
}
