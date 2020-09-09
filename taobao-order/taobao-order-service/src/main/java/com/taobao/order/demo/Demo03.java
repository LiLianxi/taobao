package com.taobao.order.demo;

import java.math.BigDecimal;

/**
 * @author Lawrence Li
 * @date 2020/8/26 3:02 PM
 */
public class Demo03 {
    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(1);
        System.out.println(a);
//        BigDecimal b = BigDecimal.valueOf(4.09D);
//        a = a.add(b);
//        System.out.println(a);

        BigDecimal c = new BigDecimal("0.000000");
        System.out.println(c);

    }
}
