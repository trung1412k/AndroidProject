package com.example.android_lession03_retrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("feature_image_path")
    @Expose
    public String featureImagePath;
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("category_id")
    @Expose
    public Integer categoryId;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("feature_image_name")
    @Expose
    public String featureImageName;

}
