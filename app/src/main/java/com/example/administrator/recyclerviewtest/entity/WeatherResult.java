package com.example.administrator.recyclerviewtest.entity;

/**
 * Created by ZZB on 2016/3/28.
 */
public class WeatherResult {

    private int errNum;
    private String errMsg;
    private Object retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getRetData() {
        return retData;
    }

    public void setRetData(Object retData) {
        this.retData = retData;
    }
}
