package com.dayi.demo.error;

public enum BusinessEnum implements CommonError {
    PARAMETER_ERROR(10001, "传入参数非法"),
    SECKILL_CLOSE(20001, "秒杀关闭"),
    REPEAT_ADD(30001, "重复插入"),
    UNKNOW_ERROR(40001, "未知异常")
    ;

    private BusinessEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private int errorCode;

    private String errorMsg;

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public CommonError setErrorMsg(String msg) {
        this.errorMsg = msg;
        return this;
    }
}
