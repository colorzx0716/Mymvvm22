package com.bawie.mymvvm2.utils;

import com.bawie.mymvvm2.common.Api;
import com.bawie.mymvvm2.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class NetRequestUtils {

    private ApiService apiService;

    public static NetRequestUtils mInstance;

    public ApiService getApiService() {
        return apiService;
    }

    public NetRequestUtils(ApiService apiService) {
        this.apiService = apiService;
    }

    public static class Builder{
        private List<Converter.Factory> converterFactories = new ArrayList<>();
        private List<CallAdapter.Factory> calladaperFactories = new ArrayList<>();

        public Builder addConverterFactory(Converter.Factory factory) {
            converterFactories.add(factory);
            return this;

        }

        public Builder addCalladapterFactory(CallAdapter.Factory factory) {
            calladaperFactories.add(factory);

            return this;

        }

        public NetRequestUtils build() {
            OkHttpClient.Builder okbuilder = new OkHttpClient.Builder();
            okbuilder.addInterceptor(new ParamsInterceptor());

            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(Api.BASE_URL).client(okbuilder.build());

            if (converterFactories.size() == 0) {
                converterFactories.add(GsonConverterFactory.create());
            } else {
                for (Converter.Factory converterFactory : converterFactories) {
                    builder.addConverterFactory(converterFactory);
                }
            }
            if (calladaperFactories.size() == 0) {
                calladaperFactories.add(RxJava2CallAdapterFactory.create());

            } else {
                for (CallAdapter.Factory calladaperFactory : calladaperFactories) {
                    builder.addCallAdapterFactory(calladaperFactory);
                }
            }

            ApiService apiService = builder.build().create(ApiService.class);

            mInstance = new NetRequestUtils(apiService);
            return mInstance;
        }

    }
}



