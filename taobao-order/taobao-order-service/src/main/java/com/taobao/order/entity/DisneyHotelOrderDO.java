package com.taobao.order.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Lawrence Li
 * @date 2020/11/3 2:27 PM
 */
@Data
public class DisneyHotelOrderDO {

    private Long id;
    private String objectId;
    private String orderId;
    private Integer status;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
