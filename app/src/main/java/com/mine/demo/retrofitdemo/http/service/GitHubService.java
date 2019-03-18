package com.mine.demo.retrofitdemo.http.service;

import com.mine.demo.retrofitdemo.bean.UserInfo;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Retrofit interface
 *
 * @author chenmingqun
 * @date 2016/7/12
 */
public interface GitHubService {
    @GET("users/{user}")
    Call<UserInfo> getUserInfoCall(@Path("user") String userName);

    @GET("users/{user}")
    Observable<UserInfo> getUserInfo(@Path("user") String userName);

    @GET("users/{user}")
    Observable<ResponseBody> executeGet(@Path("user") String userName);
}

