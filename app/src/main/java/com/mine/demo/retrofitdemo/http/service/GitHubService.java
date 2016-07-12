package com.mine.demo.retrofitdemo.http.service;

import com.mine.demo.retrofitdemo.bean.UserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit interface
 * @author chenmingqun
 * @date 2016/7/12
 */
public interface GitHubService {
    @GET("users/{user}")
    Call<UserInfo> getUserInfo(@Path("user") String userName);

}

