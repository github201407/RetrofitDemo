package com.mine.demo.retrofitdemo.http.service;

import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.reflect.TypeToken;
import com.mine.demo.retrofitdemo.R;
import com.mine.demo.retrofitdemo.bean.BaseResponse;
import com.mine.demo.retrofitdemo.bean.IPInfo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Response;

public class RxUtils {

    /**
     * 设置不同线程
     *
     * @param observable
     * @param <T>
     * @return
     */
    public static <T> Observable<T> toSubscribe(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 数据转换格式 ResponseBody -> String
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

    /**
     * 数据转换格式 String -> T
     *
     * @return
     */
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

    /**
     * 数据转换格式 String -> T
     *
     * @return
     */
    public static <T> ObservableTransformer<ResponseBody, T> transStringToObject(final TypeToken<T> typeToken) {
        return new ObservableTransformer<ResponseBody, T>() {
            @Override
            public ObservableSource<T> apply(Observable<ResponseBody> upstream) {
                return upstream.map(new Function<ResponseBody, T>() {
                    @Override
                    public T apply(ResponseBody value) throws Exception {
                        BufferedSource bufferedSource = Okio.buffer(value.source());
                        String text = bufferedSource.readUtf8();
                        bufferedSource.close();
                        return GsonUtils.fromJson(text, typeToken.getType());
                    }
                });
            }
        };
    }

    /**
     * 倒计时
     * RxUtils.countdown(60).subscribe(new Subscriber<Integer>() {})
     * @param time
     * @return
     */
    public static Observable<Integer> countDown(int time) {
        if (time < 0) time = 0;

        final int countTime = time;
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(Long aLong) throws Exception {
                        return countTime - aLong.intValue();
                    }
                })
                .take(countTime + 1);

    }
}
