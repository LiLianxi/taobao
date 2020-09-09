package com.taobao.order.mq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author Lawrence Li
 * @date 2020/9/9 4:00 PM
 */
public class CancelBookingInOperaSender extends AbstractSender<CancelBookingInOperaDTO> {

    private static final Logger logger = LoggerFactory.getLogger(CancelBookingInOperaSender.class);

    public CancelBookingInOperaSender(String exchange, String routingKey, RabbitTemplate rabbitTemplate) {
        super(exchange, routingKey, rabbitTemplate);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info("send message to cancel booking in Opera");
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        String correlationId = message.getMessageProperties().getCorrelationId();
        String errorInfo = "correlationId" + correlationId + "exchange: " + exchange + ", routingKey: "
                + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText;
        logger.info(errorInfo);
    }

}
