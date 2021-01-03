package com.example.android_lession03_retrofit.utils;

import com.example.android_lession03_retrofit.retrofit.RetrofitClient;
import com.example.android_lession03_retrofit.service.SOService;

public class ApiUtils {
    public static final String BASE_URL = "http://10.0.2.2:8000/api/";

    public static SOService getSOService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(SOService.class);
    }
}
