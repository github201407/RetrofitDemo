package com.mine.demo.retrofitdemo.http.service;

public class Api {

    public static GitHubService service() {
        return RetrofitUtils.getInstance().getRetrofit().create(GitHubService.class);
    }
}
