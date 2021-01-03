package com.example.android_lession03_retrofit.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("code")
    @Expose
    public int code;
}
