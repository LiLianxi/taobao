package com.taobao.order.mq.producer;

/**
 * @author Lawrence Li
 * @date 2020/9/9 4:00 PM
 */
public class CancelBookingInOperaDTO {

    private String confirmationNumber;
    private String brandCode;

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    @Override
    public String toString() {
        return "CancelBookingInOperaDTO{" +
                "confirmationNumber='" + confirmationNumber + '\'' +
                ", brandCode='" + brandCode + '\'' +
                '}';
    }

}
