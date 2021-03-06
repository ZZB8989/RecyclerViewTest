package com.example.administrator.recyclerviewtest;

import android.os.Bundle;
import android.os.Message;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * Created by Administrator on 2016/3/20.
 */
public class Connection {


    /**
     * 同步请求
     * @param urlAll
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    public static String request(String httpUrl, String httpArg) {
        String result = null;
        httpUrl = httpUrl + "?" + httpArg;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(httpUrl)
                .header("apikey", "b7c0e80f7e2a8767a3886952c632ed79")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            result=response.body().string();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;
    }
}
