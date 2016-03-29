package com.example.administrator.recyclerviewtest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 */
public class JsonHelper {
    private static Gson sGson;
    private static Gson getGson() {
        if (sGson == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            sGson = gsonBuilder.create();
        }
        return sGson;
    }
    public static String objectToJson(Object obj) {
        String strJson = getGson().toJson(obj);
        return strJson;
    }
    public static <T> T jsonToObject(String json, Type tokenType) {
        T t = null;
        try {
            t = getGson().fromJson(json, tokenType);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return t;
    }

    public static <T>T toObject(String jsonString,Class<T> mclass)
    {
        Gson gson=new Gson();
        return gson.fromJson(jsonString, mclass);
    }
    /**
     * @param jsonString
     *            :多日获得的json字符串
     * @return 返回结果
     */
    public static <T> List<T> toObjectList(String jsonString,Class<T> mclass)
    {
        // json转为带泛型的list
        Gson gson=new Gson();
        List<T> objectList = gson.fromJson(jsonString,
            new TypeToken<List<T>>() {
        }.getType());
        return objectList;
    }

    public static List<FHBean> toRecentWeathersBean(String jsonString)
    {
        List<FHBean> weatherBeanList=new ArrayList<FHBean>();
        RecentWeathersBean recentWeathersBean = toObject(jsonString, RecentWeathersBean.class);
        ReturnData returnData=recentWeathersBean.getReturnData();
        FHBean today=returnData.getToday();
        List<FHBean>  forecast=returnData.getForecast();
        List<FHBean> history=returnData.getHistory();
        weatherBeanList.addAll(history);
        weatherBeanList.add(today);
        weatherBeanList.addAll(forecast);
        return weatherBeanList;

    }
}
