package com.dayi.demo.error;

/**
 * @author GuoXuJun <guoxj@pvc123.com>
 * @date 2019/4/12
 */
public interface CommonError {

    int getErrorCode();

    String getErrorMsg();

    CommonError setErrorMsg(String msg);

}
