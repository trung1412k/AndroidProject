package com.example.android_lession03_retrofit.service;

import com.example.android_lession03_retrofit.responses.ListProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SOService {
    @GET("products")
    Call<ListProductResponse> getProducts();
}
