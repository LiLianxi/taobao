package com.taobao.order.config.rabbitmq;

import com.taobao.order.mq.producer.CancelBookingInOperaSender;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import static com.taobao.order.common.constants.MQConstants.Exchange.*;
import static com.taobao.order.common.constants.MQConstants.Queue.*;
import static com.taobao.order.common.constants.MQConstants.RoutingKey.*;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:32 PM
 */
@Configuration
public class RabbitSenderConfiguration {
    /**
     *  direct exchange
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(HOTEL_EXCHANGE_DIRECT);
    }

    /**
     * topic exchange
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(HOTEL_EXCHANGE_TOPIC);
    }

    /**
     *  dead letter exchange
     * @return
     */
    @Bean
    public DirectExchange dlxExchange(){
        return new DirectExchange(CANCEL_ORDER_DLX_DIRECT);
    }

    /**
     * dead letter queue
     * @return
     */
    @Bean
    public Queue cancelHotelOrderFailedQueue() {
        return new Queue(HOTEL_ORDER_CANCEL_DLX, true,false,false, null);
    }
    @Bean
    public Binding cancelOrderFailedBinding(){
        return BindingBuilder.bind(cancelHotelOrderFailedQueue()).to(dlxExchange()).with(ORDER_CANCEL_DLX_KEY);
    }

    /** makePayment */
    @Bean
    public Queue makePaymentQueue(){
        return new Queue(HOTEL_ORDER_MAKE_PAYMENT,true, false, false, null);
    }
    @Bean
    public Binding makePaymentBinding(){
        return BindingBuilder.bind(makePaymentQueue()).to(topicExchange()).with(ORDER_MAKE_PAYMENT_KEY);
    }

    /** cancel order(message from adapter) */
    @Bean
    public Queue cancelHotelOrderQueue(){
        return new Queue(HOTEL_ORDER_CANCEL,true, false, false, null);
    }
    @Bean
    public Binding cancelHotelOrderBinding(){
        return BindingBuilder.bind(cancelHotelOrderQueue()).to(topicExchange()).with(BOOKING_CANCEL_REQUEST_KEY);
    }


    /** confirm hotel order(have not config)*/


    /** payment notify result (message from local) */
    @Bean
    public Queue paymentNotifyResultQueue(){
        return new Queue(PAYMENT_NOTIFY_RESULT,true, false, false, null);
    }
    @Bean
    public Binding paymentNotifyResultBinding(){
        return BindingBuilder.bind(paymentNotifyResultQueue()).to(topicExchange()).with(PAYMENT_NOTIFY_RESULT_KEY);
    }

    /** order refund (message from local) **/
    @Bean
    public Queue autoRefundQueue() {
        return new Queue(ORDER_REFUND_QUEUE,true, false, false, null);
    }
    @Bean
    public Binding autoRefundBinding() {
        return BindingBuilder.bind(autoRefundQueue()).to(topicExchange()).with(ORDER_REFUND_KEY);
    }

    /** cancel booking(message from native)*/
    @Bean
    public Queue cancelBookingInOperaQueue(){
        Map<String, Object> args = new HashMap<>(16);
        args.put("x-dead-letter-exchange", CANCEL_ORDER_DLX_DIRECT);
        args.put("x-dead-letter-routing-key", ORDER_CANCEL_DLX_KEY);
        return new Queue(OPERA_BOOKING_CANCEL,true, false, false, args);
    }
    @Bean
    public Binding cancelBookingInOperaBinding(){
        return BindingBuilder.bind(cancelBookingInOperaQueue()).to(topicExchange()).with(BOOKING_CANCEL_KEY);
    }

    /** save hotel order to local DB */
    @Bean
    public Queue saveHotelOrderQueue(){
        return new Queue(HOTEL_ORDER_SAVE, true, false, false, null);
    }
    @Bean
    public Binding saveHotelOrderBinding(){
        return BindingBuilder.bind(saveHotelOrderQueue()).to(topicExchange()).with(ORDER_SAVE_KEY);
    }


    /** SaveHotelOrderSender */
    /*@Bean
    public SaveHotelOrderSender saveHotelOrderSender(RabbitTemplate rabbitTemplate){
        return new SaveHotelOrderSender(HOTEL_EXCHANGE_TOPIC, ORDER_SAVE_KEY, rabbitTemplate);
    }*/
    /** MakePaymentResponseSender */
    /*@Bean
    public MakePaymentResponseSender makePaymentResponseSender(RabbitTemplate rabbitTemplate) {
        return new MakePaymentResponseSender(HOTEL_EXCHANGE_TOPIC, MAKE_PAYMENT_RESPONSE_KEY, rabbitTemplate);
    }*/
    /** CancelBookingInOperaSender */
    @Bean
    public CancelBookingInOperaSender cancelBookingInOperaSender(RabbitTemplate rabbitTemplate){
        return new CancelBookingInOperaSender(HOTEL_EXCHANGE_TOPIC, BOOKING_CANCEL_KEY, rabbitTemplate);
    }

}
