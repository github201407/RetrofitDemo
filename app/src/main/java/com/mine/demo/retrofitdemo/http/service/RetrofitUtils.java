package com.mine.demo.retrofitdemo.http.service;

import android.util.Log;
import android.webkit.WebSettings;

import com.blankj.utilcode.util.Utils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mine.demo.retrofitdemo.App;
import com.mine.demo.retrofitdemo.http.CustomGsonConverterFactory;
import com.mine.demo.retrofitdemo.http.CustomGsonResponseBodyConverter;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
                    .addConverterFactory(CustomGsonConverterFactory.create()/*GsonConverterFactory.create()*/)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(getSimpleInterceptor()).addInterceptor(getHttpLoggingInterceptor()).build();
    }

    private Interceptor getSimpleInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .removeHeader("User-Agent")//移除旧的
                        .addHeader("User-Agent", WebSettings.getDefaultUserAgent(Utils.getApp()))//添加真正的头部
                        .build();
                return chain.proceed(request);
            }
        };
    }

    private Interceptor getHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("ttt", "log: " + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
