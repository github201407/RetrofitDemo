package com.mine.demo.retrofitdemo.presenter;

import android.util.Log;

import com.mine.demo.retrofitdemo.bean.UserInfo;
import com.mine.demo.retrofitdemo.model.GitModel;
import com.mine.demo.retrofitdemo.view.inf.IGitView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;

/**
 * Git Presenter层
 * @author chenmingqun
 * @date 2016/7/12
 */
public class GitPresenter {
    private static final String TAG = "GitHub";
    private IGitView iGitView;
    private GitModel gitModel;

    public GitPresenter(IGitView iGitView) {
        this.iGitView = iGitView;
        this.gitModel = new GitModel();
    }

    public void initPresenter() {
        iGitView.initView();
        iGitView.initListener();
    }

    /**
     * 获取用户信息
     * RxJava 与 Retrofit 结合的最佳实践
     * <p/>
     * 参考链接： https://gank.io/post/56e80c2c677659311bed9841
     */
    public void getUserInfo() {
        gitModel.sendUserInfoRequest(iGitView.getUserName(), new Observer<UserInfo>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onNext(UserInfo userInfo) {
                iGitView.setUserInfo(userInfo);
            }
        });
    }

    /**
     * 获取用户信息
     */
    public void getUserInfoCall() {
        gitModel.sendUserInfoRequest(iGitView.getUserName(), new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                iGitView.setUserInfo(response.body());
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {

            }
        });
    }
}
