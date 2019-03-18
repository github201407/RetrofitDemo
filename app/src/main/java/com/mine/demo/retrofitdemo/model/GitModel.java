package com.mine.demo.retrofitdemo.model;

import com.google.gson.reflect.TypeToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mine.demo.retrofitdemo.bean.UserInfo;
import com.mine.demo.retrofitdemo.http.service.Api;
import com.mine.demo.retrofitdemo.http.service.GitHubService;
import com.mine.demo.retrofitdemo.http.service.RxUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Git Model层
 *
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())/*结合RxJava*/
                .build();
        service = retrofit.create(GitHubService.class);
    }

    /**
     * 发送用户信息请求
     *
     * @param userName
     * @param subscriber
     */
    public void sendUserInfoRequest1(String userName, Observer<? super UserInfo> subscriber) {
        service.getUserInfo(userName)
                .subscribeOn(Schedulers.io())/*io线程获取数据*/
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void sendUserInfoRequest(String userName, Observer<? super UserInfo> observer) {
//        Api.service().getUserInfo(userName)
//                .subscribeOn(Schedulers.io())/*io线程获取数据*/
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
        RxUtils.toSubscribe(Api.service().getUserInfo(userName)).subscribe(observer);
    }

    public void sendUserInfoRequestGet(String userName, TypeToken<UserInfo> typeToken, Observer<? super UserInfo> observer) {
        RxUtils.toSubscribe(Api.service().executeGet(userName)).compose(RxUtils.transToString()).compose(RxUtils.transToObject(typeToken)).subscribe(observer);
    }

    /**
     * 发送用户信息请求
     *
     * @param userName
     * @param callBack
     */
    public void sendUserInfoRequest(String userName, Callback<UserInfo> callBack) {
        Call<UserInfo> repos = service.getUserInfoCall(userName);
        repos.enqueue(callBack);
    }
}
