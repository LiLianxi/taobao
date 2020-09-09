package com.taobao.order.demo;

/**
 * @author Lawrence Li
 * @date 2020/8/12 3:23 PM
 */
public class Demo01 {

    private static int num = 10;

    public static void main(String[] args) {
        while (num > 0){
            num--;
            System.out.println("hello world" + num);
            if (num == 5){
               continue;
            }
        }
    }
}
