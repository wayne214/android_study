package com.example.androidstudy.bean;

public class ResultInfo {

    /**
     * errorCode : 0
     * errorMsg :
     */

    private int errorCode;
    private String errorMsg;
    private DataInfo data;

    public DataInfo getDataInfo() {
        return data;
    }

    public void setDataInfo(DataInfo dataInfo) {
        this.data = dataInfo;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
