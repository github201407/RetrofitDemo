package com.mine.demo.retrofitdemo;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
