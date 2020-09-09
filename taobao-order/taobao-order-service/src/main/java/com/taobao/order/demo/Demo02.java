package com.taobao.order.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lawrence Li
 * @date 2020/8/20 2:38 PM
 */
@Slf4j
public class Demo02 {
    public static void main(String[] args) {
        stringMethodDemo();
    }

    private static void stringMethodDemo() {

        String s2 = "dei";
        String s1 = "abchdeigjdhuywhvndjrg";
        System.out.println(s1.indexOf("h"));
        log.info("hello --> {}", "world");


    }
}
