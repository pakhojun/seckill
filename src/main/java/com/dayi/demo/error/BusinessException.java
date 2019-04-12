package com.dayi.demo.error;

/**
 * @author GuoXuJun <guoxj@pvc123.com>
 * @date 2019/4/12
 */
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public BusinessException(CommonError commonError, String msg) {
        super();
        this.commonError = commonError;
        this.setErrorMsg(msg);
    }

    @Override
    public int getErrorCode() {
        return this.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String msg) {
        this.setErrorMsg(msg);
        return this;
    }
}
