package com.example.administrator.recyclerviewtest.http;

/**
 * Created by ZZB on 2016/3/28.
 */
public class WeatherHttpClient extends BaseHttpClient {
    @Override
    protected HttpSerializer getHttpSerializer() {
        return new WeatherHttpSerializer();
    }
}
