package com.yjq.electricitysystem.exception;

public class CustomException extends RuntimeException {

    private String msg;
    private String code;

    public CustomException(String msg, String code) {
        super(msg);         //正常显示
        //this.msg = msg;   //无法显示
        this.code = code;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }
}
