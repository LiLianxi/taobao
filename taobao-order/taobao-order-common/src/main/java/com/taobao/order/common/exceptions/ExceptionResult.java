package com.taobao.order.common.exceptions;

import org.joda.time.DateTime;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:40 PM
 */
public class ExceptionResult {

    private Integer status;
    private String message;
    private String timestamp;

    public ExceptionResult(HotelException e){
        this.status = e.getCode();
        this.message = e.getMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }

    public ExceptionResult(MakePaymentException e){
        this.status = e.getCode();
        this.message = e.getMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }

    public ExceptionResult(BadRequestException e){
        this.status = e.getStatus();
        this.message = e.getMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
