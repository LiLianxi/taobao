package com.taobao.order.demo;

/**
 * @author Lawrence Li
 * @date 2020/8/7 2:05 PM
 */
public class OutPrint implements Runnable{

    private Person person;

    public OutPrint(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            person.out();
        }
    }
}
