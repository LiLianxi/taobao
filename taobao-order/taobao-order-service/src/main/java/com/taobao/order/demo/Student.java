package com.taobao.order.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDate;

/**
 * @author Lawrence Li
 * @date 2020/10/26 11:41 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private ObjectId id;
    private String name;
    private int age;
    private Address address;
    private String birthday;

}
