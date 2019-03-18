package com.mine.demo.retrofitdemo.http.service;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private Retrofit retrofit;

    private RetrofitUtils() {

    }

    private static class SingletonHolder {
        private static final RetrofitUtils INSTANCE = new RetrofitUtils();
    }

    public static RetrofitUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(HttpConstant.BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(getHttpLoggingInterceptor()).build();
    }

    private Interceptor getHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("ttt", "log: " + message);
            }
        });
    }
}
