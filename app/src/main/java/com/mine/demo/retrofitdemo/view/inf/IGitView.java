package com.mine.demo.retrofitdemo.view.inf;

import com.mine.demo.retrofitdemo.bean.UserInfo;

/**
 * Git View层
 * @author chenmingqun
 * @date 2016/7/12
 */
public interface IGitView {
    /**初始化View*/
    void initView();
    /**初始化Listener*/
    void initListener();
    /**设置用户信息*/
    void setUserInfo(String text);
    /**返回用户名*/
    String getUserName();
}
