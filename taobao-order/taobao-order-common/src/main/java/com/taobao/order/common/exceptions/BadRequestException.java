package com.taobao.order.common.exceptions;

import com.taobao.order.common.enums.ExceptionEnum;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:50 PM
 */
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 7856365955971688783L;

    private Integer status;

    public BadRequestException(ExceptionEnum e) {
        super(e.getMessage());
        this.status = e.getStatus();
    }

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    protected BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Integer getStatus() {
        return status;
    }

}
