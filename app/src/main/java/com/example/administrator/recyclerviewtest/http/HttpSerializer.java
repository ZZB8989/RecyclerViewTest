package com.example.administrator.recyclerviewtest.http;

import com.example.administrator.recyclerviewtest.exception.RequestException;

/**
 * Created by ZZB on 2016/3/26.
 */
public interface HttpSerializer {

    Object toObject(Object clazz, int statusCode, byte[] body) throws RequestException;
}
