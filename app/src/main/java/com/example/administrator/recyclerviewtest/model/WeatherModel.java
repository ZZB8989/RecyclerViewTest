package com.example.administrator.recyclerviewtest.model;

import com.example.administrator.recyclerviewtest.http.HttpCallback;
import com.example.administrator.recyclerviewtest.http.HttpRequest;
import com.example.administrator.recyclerviewtest.http.HttpRequest.Builder;
import com.example.administrator.recyclerviewtest.http.WeatherHttpClient;

/**
 * Created by ZZB on 2016/3/26.
 */
public class WeatherModel {
    private WeatherHttpClient mHttpClient = new WeatherHttpClient();


    public void getBJRecentWeathers(HttpCallback callback) {
        String url = "http://apis.baidu.com/apistore/weatherservice/recentweathers";
        HttpRequest.Builder builder = new Builder();
        HttpRequest request = builder.url(url)
                .addParams("cityname", "%E5%8C%97%E4%BA%AC").addParams("cityid", "101010100")
                .addHeader("apikey", "b7c0e80f7e2a8767a3886952c632ed79").build();
        mHttpClient.request(request, callback);
    }
}
