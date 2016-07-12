package com.mine.demo.retrofitdemo.presenter;

import com.mine.demo.retrofitdemo.bean.UserInfo;
import com.mine.demo.retrofitdemo.model.GitModel;
import com.mine.demo.retrofitdemo.view.inf.IGitView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
     */
    public void getUserInfo() {
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
