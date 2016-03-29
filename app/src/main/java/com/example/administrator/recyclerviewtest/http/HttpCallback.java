package com.example.administrator.recyclerviewtest.http;

/**
 * Created by ZZB on 2016/3/26.
 */
public abstract class HttpCallback<T> {
    public Class clazz;
    public HttpCallback(Class cls){
        clazz = cls;
    }

    public abstract void onResponseSuccess(T result);
    public abstract void onResponseFailed(int errorCode, String errorMsg);
}
