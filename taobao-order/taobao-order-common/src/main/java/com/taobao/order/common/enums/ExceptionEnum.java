package com.taobao.order.common.enums;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:42 PM
 */
public enum ExceptionEnum {


    /**
     *
     */
    PARAMS_INVALID(400,40000,"params invalid"),
    /**
     *
     */
    DATE_FORMAT_FAILED(400,40001,"the date format was invalid"),
    /**
     *
     */
    CHECKIN_DATE_INVALID(400,40002,"check-in date invalid"),
    /**
     *
     */
    CHECKOUT_DATE_INVALID(400,40003,"check-out date invalid"),
    /**
     *
     */
    EXPIRATION_DATE_INVALID(400,40004,"expiration date invalid"),
    /**
     *
     */
    CONSUME_DATE_INVALID(400,40005,"addon's consume date invalid"),
    /**
     *
     */
    ADDON_NUMBER_INVALID(400,40005,"the number of addon was invalid"),
    /**
     *
     */
    DATE_FORMAT_INVALID(400,40006,"checkin or checkout date invalid"),
    /**
     *
     */
    CHECKIN_BEFORE_CHECKOUT(400,40007,"checkout date mustn't before checkin date"),
    /**
     *
     */
    EMAIL_PHONE_ALL_NONE(400,40008,"guest's email and phoneNumber cannot be null at the same time"),
    /**
     *
     */
    GUEST_PHONE_INVALID(400,40009,"guest's phoneNumber was invalid"),
    /**
     *
     */
    GUEST_COUNTRY_CODE_INVALID(400,40010,"guest's country code cannot not be null"),
    /**
     *
     */
    ORDERID_INVALID(400,40011,"No order data found by the orderId"),

    /**
     *
     */
    ORDER_CLOSED(400,40012,"the order has been closed"),

    /**
     *
     */
    ADULT_NUM_INVALID(400,40201,"the adult number was invalid"),

    /**
     *
     */
    CHILD_NUM_INVALID(400, 40202,"the child number was invalid"),

    /**
     *
     */
    GUEST_NUM_INVALID(400, 40203,"the guest number was invalid"),


    /**
     *
     */
    REQUEST_OWS_FAILED(404,40101,"request Opera failed"),

    /**
     *
     */
    ORDERID_EXISTED(400, 40000,"the orderId(required unique) already exist in DB table"),

    /**
     *
     */
    BRAND_NOT_FOUND(404, 40401,"brand not found"),
    /**
     *
     */
    CATEGORY_NOT_FOUND(404, 40402,"category not found"),
    /**
     *
     */
    SPEC_NOT_FOUND(404, 40403,"spec not found"),
    /**
     *
     */
    ORDER_NOT_FOUND(404, 40404,"order not found"),
    /**
     *
     */
    ORDER_DETAIL_NOT_FOUND(404, 40405,"order detail not found"),
    /**
     *
     */
    ACP_CONTENT_NOT_FOUND(404,40406,"ACP content not found"),
    /**
     * my reservation not found
     */
    MY_RESERVATION_NOT_FOUND(404,40407,"my reservation not found"),

    /**
     * get my reservation failed
     */
    GET_MY_RESERVATION_FAILED(500,50101,"get my reservation failed"),

    /**
     *
     */
    BOOKING_LIMITATION_ERROR(500,50001,"one account can only booking five rooms within a day"),

    /**
     *
     */
    CANCEL_LIMITATION_ERROR(500,50001,"one account can only cancel five rooms within a day"),
    /**
     *
     */
    DETAIL_AVAILABILITY_FAILED(500,50004,"get detail availability from Opera failed"),
    /**
     *
     */
    DETAIL_AVAILABILITY_RESPONSE_FAIL(500,50004,"get hotel detail availability from Opera but returned FAIL"),
    /**
     *
     */
    AVAILABLE_PACKAGES_FAILED(500,50004,"get available packages from Opera failed"),
    /**
     *
     */
    AVAILABLE_PACKAGES_RESPONSE_FAIL(500,50004,"get hotel available packages from Opera but returned FAIL"),
    /**
     *
     */
    PRICE_CHANGED(500,50000,"the charge has changed, please check again"),


    /**
     *
     */
    GET_BOOKINGLOCK_FAILED(500,50000,"get distributed bookingLock failed"),

    /**
     *
     */
    OPERA_CREATE_BOOKING_FAILED(500,50000,"create booking in Opera failed"),
    /**
     *
     */
    OPERA_MAKE_PAYMENT_FAILED(500,50000,"make payment in Opera failed"),
    /**
     *
     */
    MAKE_PAYMENT_FAILED(500,50000,"make payment failed"),
    /**
     *
     */
    CANCEL_OWS_BOOKING_FAILED(500,50000,"cancel booking in Opera failed"),

    /**
     *
     */
    CREATE_PAYMENT_SESSION_FAILED(500,50000,"create payment session failed"),

    /**
     *
     */
    ADDON_INSERT_OPERATION_FAILED(500,50000,"save addons to DB failed"),

    /**
     *
     */
    ORDER_INSERT_OPERATION_FAILED(500,50000,"save hotel order to DB failed"),

    /**
     *
     */
    ORDER_PAYMENT_INSERT_OPERATION_FAILED(500,50000,"save hotel order payment info to DB failed"),


    /**
     *
     */
    CANCEL_LOCAL_BOOKING_FAILED(500,50004,"cancel local DB order failed"),

    /**
     *
     */
    GET_PACKAGE_CONTENT_FAILED(500,50004,"get package content failed"),

    /**
     *
     */
    GET_ADDON_PRICE_FAILED(500,50004,"get addons price failed"),

    /**
     *
     */
    DATA_TRANSFER_ERROR(500,50000, "data transfer error"),
    /**
     *
     */
    INSERT_OPERATION_FAIL(500,50000, "insert operation error"),
    /**
     *
     */
    UPDATE_OPERATION_FAIL(500,50000, "update operation error"),
    /**
     *
     */
    DELETE_OPERATION_FAIL(500,50000, "delete operation error"),

    /**
     *
     */
    INVALID_ORDER_STATUS(500,50000, "invalid order status");

    private Integer status;
    private Integer code;
    private String message;


    ExceptionEnum(Integer status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
