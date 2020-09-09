package com.taobao.order.demo;

/**
 * @author Lawrence Li
 * @date 2020/8/7 2:07 PM
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Person person = new Person();

        Input in = new Input(person);
        OutPrint out = new OutPrint(person);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();

    }

}
