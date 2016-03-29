package com.example.administrator.recyclerviewtest.http;

import android.text.TextUtils;

import com.example.administrator.recyclerviewtest.JsonHelper;
import com.example.administrator.recyclerviewtest.entity.WeatherResult;
import com.example.administrator.recyclerviewtest.exception.RequestException;

import java.lang.reflect.Type;

/**
 * Created by ZZB on 2016/3/28.
 */
public class WeatherHttpSerializer implements HttpSerializer {
    @Override
    public Object toObject(Object clazz, int statusCode, byte[] body) throws RequestException {
        try {
            String json = new String(body, "UTF-8");
            WeatherResult result = JsonHelper.toObject(json, WeatherResult.class);
            Object retData = result.getRetData();
            if (retData != null && !TextUtils.isEmpty(retData.toString().trim())) {
                json = JsonHelper.objectToJson(retData);
            }else{
                throw new RequestException("数据返回为空");
            }
            if (clazz instanceof Class) {
                return JsonHelper.toObject(json, (Class) clazz);
            } else {
                return JsonHelper.jsonToObject(json, (Type) clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RequestException(e, statusCode, "");
        }
    }
}
