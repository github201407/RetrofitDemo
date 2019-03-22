package com.mine.demo.retrofitdemo.http.service;

import com.mine.demo.retrofitdemo.bean.BaseResponse;
import com.mine.demo.retrofitdemo.bean.IPInfo;
import com.mine.demo.retrofitdemo.bean.UserInfo;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    // http://ip.taobao.com/instructions.html
    @GET("http://ip.taobao.com/service/getIpInfo.php?k=5")
    Observable<BaseResponse<IPInfo>> getIpInfo(@Query("ip") String ip);
}

