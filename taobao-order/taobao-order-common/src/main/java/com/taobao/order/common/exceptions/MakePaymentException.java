package com.taobao.order.common.exceptions;

import com.taobao.order.common.enums.ExceptionEnum;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:41 PM
 */
public class MakePaymentException extends RuntimeException {
    private static final long serialVersionUID = 2524639563178533030L;

    private Integer status;
    private Integer code;

    public MakePaymentException(ExceptionEnum e){
        super(e.getMessage());
        this.status = e.getStatus();
        this.code = e.getCode();
    }

    public MakePaymentException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public MakePaymentException(Integer status, Integer code, String message) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public MakePaymentException() {
        super();
    }

    public MakePaymentException(String message) {
        super(message);
    }

    public MakePaymentException(String message, Throwable cause) {
        super(message, cause);
    }

    public MakePaymentException(Throwable cause) {
        super(cause);
    }

    protected MakePaymentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }


}
