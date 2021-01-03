package com.example.android_lession03_retrofit.responses;

import com.example.android_lession03_retrofit.models.Product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListProductResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    public List<Product> listProduct;
}
