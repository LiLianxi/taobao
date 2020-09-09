package com.taobao.order.mq.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;

import java.util.UUID;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:57 PM
 */
public abstract class AbstractSender<T> implements RabbitSender<T>, RabbitTemplate.ReturnCallback, RabbitTemplate.ConfirmCallback {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSender.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public RabbitTemplate rabbitTemplate;

    private String exchange;

    private String routingKey;

    public AbstractSender(String exchange, String routingKey, RabbitTemplate rabbitTemplate) {
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void send(T t, String msgId) {
        sendLog(t);
        rabbitTemplate.convertAndSend(exchange, routingKey, build(t), new CorrelationData(msgId));
    }

    @Override
    public void send(T t) {
        sendLog(t);
        rabbitTemplate.convertAndSend(exchange, routingKey, build(t));
    }

    @Override
    public void sendObject(T t) {
        sendLog(t);
        rabbitTemplate.convertAndSend(exchange, routingKey, t);
    }

    @Override
    public void sendObject(T t, String msgId) {
        sendLog(t);
        rabbitTemplate.convertAndSend(exchange, routingKey, t, new CorrelationData(msgId));
    }

    private void sendLog(T t) {
        logger.info("send message: {} ", t.toString());
    }

    private Message build(T t) {
        try {
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            messageProperties.setContentType(MediaType.APPLICATION_JSON_VALUE);
            messageProperties.setContentEncoding("utf-8");
            String messageId = UUID.randomUUID().toString();
            messageProperties.setMessageId(messageId);
            String messageJson = OBJECT_MAPPER.writeValueAsString(t);
            return new Message(messageJson.getBytes(), messageProperties);

//            String json = OBJECT_MAPPER.writeValueAsString(t);
//            Message message = MessageBuilder
//                    .withBody(json.getBytes())
//                    .setContentType(MessageProperties.CONTENT_TYPE_JSON)
//                    .build();
//            return message;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("convert mq message error");
        }
    }


}
