package com.mine.demo.retrofitdemo.http.service;

import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.reflect.TypeToken;
import com.mine.demo.retrofitdemo.bean.UserInfo;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

public class RxUtils {

    /**
     * 设置不同线程
     *
     * @param o
     * @param <T>
     * @return
     */
    public static <T> Observable<T> toSubscribe(Observable<T> o) {
        return o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 转换格式
     *
     * @return
     */
    public static ObservableTransformer<ResponseBody, String> transToString() {
        return new ObservableTransformer<ResponseBody, String>() {
            @Override
            public ObservableSource<String> apply(Observable<ResponseBody> upstream) {
                return upstream.map(new Function<ResponseBody, String>() {
                    @Override
                    public String apply(ResponseBody value) throws Exception {
                        BufferedSource bufferedSource = Okio.buffer(value.source());
                        String text = bufferedSource.readUtf8();
                        bufferedSource.close();
                        return text;
                    }
                });
            }
        };
    }

    public static <T> ObservableTransformer<? super String, T> transToObject(final TypeToken<T> typeToken) {
        return new ObservableTransformer<String, T>() {
            @Override
            public ObservableSource<T> apply(Observable<String> upstream) {
                return upstream.map(new Function<String, T>() {
                    @Override
                    public T apply(String s) throws Exception {
                        return GsonUtils.fromJson(s, typeToken.getType());
                    }
                });
            }
        };
    }
}
