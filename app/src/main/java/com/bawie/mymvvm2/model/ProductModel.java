package com.bawie.mymvvm2.model;

import com.bawie.mymvvm2.entity.BaseResponseEntity;
import com.bawie.mymvvm2.entity.Product;
import com.bawie.mymvvm2.utils.MyCallback;
import com.bawie.mymvvm2.utils.NetRequestUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class ProductModel {

    public void getData(){

        new NetRequestUtils.Builder().addCalladapterFactory(RxJava2CallAdapterFactory.create())
             .addConverterFactory(GsonConverterFactory.create())
                .build().getApiService().getAd()
                .enqueue(new MyCallback<BaseResponseEntity<List<Product>>>() {
                    @Override
                    protected void failure(Call<BaseResponseEntity<List<Product>>> call, Throwable t) {

                    }

                    @Override
                    public void toLogin() {

                    }

                    @Override
                    protected void failMsg(String msg) {

                    }

                    @Override
                    public void success(Response<BaseResponseEntity<List<Product>>> response) {
                        productResponse.success(response);
                    }
                });

    }

    private ProductResponse productResponse;

    public void setProductResponse(ProductResponse productResponse) {
        this.productResponse = productResponse;
    }

    public interface ProductResponse{
        void success(Response<BaseResponseEntity<List<Product>>> response);
    }


}
