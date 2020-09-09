package com.taobao.order.common.exceptions;

import com.taobao.order.common.enums.ExceptionEnum;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:41 PM
 */
public class HotelException extends RuntimeException {

    private static final long serialVersionUID = 7122448934079935773L;

    private Integer status;
    private Integer code;

    public HotelException(ExceptionEnum e) {
        super(e.getMessage());
        this.status = e.getStatus();
        this.code = e.getCode();
    }

    public HotelException(Integer status, String message){
        super(message);
        this.status = status;
    }

    public HotelException(Integer status,Integer code, String message){
        super(message);
        this.status = status;
        this.code = code;
    }


    public HotelException() {
        super();
    }

    public HotelException(String message){
        super(message);
    }

    public HotelException(String message, Throwable cause) {
        super(message, cause);
    }

    public HotelException(Throwable cause) {
        super(cause);
    }

    public HotelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

}
