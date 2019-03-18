package com.mine.demo.retrofitdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mine.demo.retrofitdemo.bean.UserInfo;
import com.mine.demo.retrofitdemo.presenter.GitPresenter;
import com.mine.demo.retrofitdemo.view.inf.IGitView;

public class MainActivity extends Activity implements IGitView, View.OnClickListener {

    private Button getInfoBtn;/*获取信息按钮*/
    private GitPresenter gitPresenter;
    private TextView showInfo;/*显示用户信息*/
    private EditText inputUserName;/*填写用户名*/
    private Button getUserInfoCall;
    private Button getUserInfoGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gitPresenter = new GitPresenter(this);
        gitPresenter.initPresenter();
    }

    /**
     * 初始化View
     */
    @Override
    public void initView() {
        inputUserName = (EditText) findViewById(R.id.inputUserName);
        getInfoBtn = (Button) findViewById(R.id.getUserInfo);
        getUserInfoCall = (Button) findViewById(R.id.getUserInfoCall);
        showInfo = (TextView) findViewById(R.id.showInfo);
        getUserInfoGet = (Button) findViewById(R.id.getUserInfoGet);
    }

    /**
     * 初始化Listener
     */
    @Override
    public void initListener() {
        getInfoBtn.setOnClickListener(this);
        getUserInfoCall.setOnClickListener(this);
        getUserInfoGet.setOnClickListener(this);
    }

    /**
     * 返回用户名
     */
    @Override
    public String getUserName() {
        return inputUserName.getText().toString().trim();
    }

    /**
     * 设置用户信息
     *
     * @param text
     */
    @Override
    public void setUserInfo(String text) {
        showInfo.setText(text);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getUserInfo:
                gitPresenter.getUserInfo();
                break;
            case R.id.getUserInfoCall:
                showInfo.setText("");
                gitPresenter.getUserInfoCall();
                break;
            case R.id.getUserInfoGet:
                showInfo.setText("");
                gitPresenter.getUserInfoGet();
                break;
            default:
                break;
        }
    }
}
