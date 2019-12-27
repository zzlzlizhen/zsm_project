package com.zsm.personplay.common;

public enum RetCode {
    //成功
    SUCCESS(200),
    //失败
    FAIL(400),
    //内部错误
    ERROR(500);
    private int code;
    private RetCode(Integer code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
