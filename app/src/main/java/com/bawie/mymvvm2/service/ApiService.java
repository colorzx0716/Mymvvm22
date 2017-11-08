package com.bawie.mymvvm2.service;

import com.bawie.mymvvm2.entity.BaseResponseEntity;
import com.bawie.mymvvm2.entity.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    @GET("ad/getAd")
    Call<BaseResponseEntity<List<Product>>> getAd();

}
