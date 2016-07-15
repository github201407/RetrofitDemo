package com.mine.demo.retrofitdemo.model;

import com.mine.demo.retrofitdemo.bean.UserInfo;
import com.mine.demo.retrofitdemo.http.service.GitHubService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Git Model层
 * @author chenmingqun
 * @date 2016/7/12
 */
public class GitModel {

    private static final String TAG = "GitHub";
    private final GitHubService service;


    public GitModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())/*结合RxJava*/
                .build();
        service = retrofit.create(GitHubService.class);

    }

    /**
     * 发送用户信息请求
     * @param userName
     * @param subscriber
     */
    public void sendUserInfoRequest(String userName, Observer<? super UserInfo> subscriber) {
        service.getUserInfo(userName)
                .subscribeOn(Schedulers.io())/*io线程获取数据*/
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
    }
//
//    /**
//     * 发送用户信息请求
//     * @param userName
//     * @param callBack
//     */
//    public void sendUserInfoRequest(String userName, Callback<UserInfo> callBack) {
//        Call<UserInfo> repos = service.getUserInfo(userName);
//        repos.enqueue(callBack);
//    }
}
