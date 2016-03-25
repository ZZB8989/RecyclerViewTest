package com.example.administrator.recyclerviewtest.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZZB on 2016/3/25.
 */
public class HttpRequest {
    private Map<String, Object> params;
    private Map<String, String> headers;
    private String url;
    private Method method = Method.GET;
    public enum Method{
        POST, GET
    }
    public HttpRequest(Builder builder){
        params = builder.params;
        url = builder.url;
        method = builder.method;
        headers = builder.headers;
    }
    public static class Builder{
        private Map<String, Object> params = new HashMap<>();
        private Map<String, String> headers = new HashMap<>();
        private String url;
        private Method method = Method.GET;

        private Builder method(Method method){
            this.method = method;
            return this;
        }
        private Builder url(String url){
            this.url = url;
            return this;
        }
        private Builder addParams(String key, Object value){
            params.put(key, value);
            return this;
        }
        private Builder addHeader(String key, String value){
            headers.put(key, value);
            return this;
        }
        public HttpRequest build(){
            return new HttpRequest(this);
        }
    }

}
