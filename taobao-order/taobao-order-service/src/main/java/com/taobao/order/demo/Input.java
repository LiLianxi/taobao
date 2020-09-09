package com.taobao.order.demo;

/**
 * @author Lawrence Li
 * @date 2020/8/7 2:03 PM
 */
public class Input implements Runnable {

    private Person person;

    public Input(Person person) {
        this.person = person;
    }

    @Override
    public void run() {

        while (true){
            person.set("james",23);
        }

    }
}
