package com.taobao.order.mq.producer;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:58 PM
 */
public interface RabbitSender<T> {

    void send(T t, String msgId);


    void send(T t);


    void sendObject(T t);


    void sendObject(T t, String msgId);

}
