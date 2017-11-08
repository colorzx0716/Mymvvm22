package com.bawie.mymvvm2.utils;

import com.bawie.mymvvm2.entity.BaseResponseEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 */

public abstract class MyCallback <T extends BaseResponseEntity> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if("0".equals(response.body().code)){
            success(response);

        }else if("1".equals(response.body().code)){
            failMsg(response.body().msg);

        }else if("2".equals(response.body().code)){
            toLogin();

        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        failure(call,t);
    }

    protected abstract void failure(Call<T> call, Throwable t);

    public abstract void toLogin();

    protected abstract void failMsg(String msg);

    public abstract void success(Response<T> response);
}
