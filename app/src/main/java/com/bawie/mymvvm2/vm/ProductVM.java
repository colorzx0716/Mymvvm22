package com.bawie.mymvvm2.vm;

import android.content.Context;

import com.bawie.mymvvm2.BR;
import com.bawie.mymvvm2.R;
import com.bawie.mymvvm2.adapter.MVVMBaseAdapter;
import com.bawie.mymvvm2.databinding.ActivityMainBinding;
import com.bawie.mymvvm2.entity.BaseResponseEntity;
import com.bawie.mymvvm2.entity.Product;
import com.bawie.mymvvm2.model.ProductModel;

import java.util.List;

import retrofit2.Response;


public class ProductVM implements ProductModel.ProductResponse{

    private Context context;
    private ProductModel productModel;
    private ActivityMainBinding binding;
    private String type = "0";
    private MVVMBaseAdapter baseAdapter = null;
    private Response<BaseResponseEntity<List<Product>>> responseData;

    public ProductVM(Context context, ActivityMainBinding binding, String type) {
        this.binding = binding;
        productModel = new ProductModel();
        productModel.getData();
        this.type = type;
        this.context = context;
        productModel.setProductResponse(this);
    }

    @Override
    public void success(Response<BaseResponseEntity<List<Product>>> response) {
        responseData = response;

        if (baseAdapter == null) {

            baseAdapter = new MVVMBaseAdapter(context, response.body().data, R.layout.layout_item, BR.product);
            binding.lv.setAdapter(baseAdapter);
        } else {

            if ("0".equals(type)) {
                baseAdapter.refresh(responseData.body().data);
                binding.lv.refreshComplete();
            } else {
                baseAdapter.loadMore(responseData.body().data);
                binding.lv.loadMoreComplete();
            }
        }
    }
    public void refresh(String type) {
        this.type = type;
        productModel.getData();

    }

    public void loadmore(String type) {
        this.type = type;
        productModel.getData();

    }



}
