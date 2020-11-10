package com.taobao.order.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Lawrence Li
 * @date 2020/11/5 4:28 PM
 */
@Data
public class UserDO {

    private Long id;
    private String username;
    private String password;
    private String phone;
    private LocalDateTime create_time;
    private LocalDateTime update_time;


}
