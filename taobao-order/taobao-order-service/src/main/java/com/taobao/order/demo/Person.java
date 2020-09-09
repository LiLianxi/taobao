package com.taobao.order.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lawrence Li
 * @date 2020/8/7 1:57 PM
 */
public class Person {
    private String name;
    private int age;

    private boolean flag = false;
    /**
     * 创建一个锁对象
     */
    private Lock lock = new ReentrantLock();
    /**
     * 创建一个监视器，用于监视生产者
     */
    private Condition producer_con = lock.newCondition();
    /**
     * 创建一个监视器，用于监视消费者
     */
    private Condition consumer_con = lock.newCondition();

    public synchronized void set(String name, int age){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.age = age;
        System.out.println("设置名字");
        flag = true;
        notify();
    }


    public synchronized void out(){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + "....." + age);
        flag = false;
        notify();
    }



}
