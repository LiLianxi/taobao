package com.taobao.order.mq.retry;

import com.rabbitmq.client.Channel;
import com.taobao.order.common.utils.JsonUtils;
import com.taobao.order.mq.producer.CancelBookingInOperaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Lawrence Li
 * @date 2020/9/28 11:07 AM
 */
@Slf4j
@Service
public class RetryRabbitMQService {

    @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 5000L, multiplier = 2))
    public void consumeOrderCanceledFailedMessage(Message message, Channel channel){

        CancelBookingInOperaDTO cancelBooking = JsonUtils.convertByteToBean(message.getBody(), CancelBookingInOperaDTO.class);
        log.info("received message: {}", cancelBooking.toString());

        //hotelService.cancelBookingInOpera(cancelBooking);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            log.error("basicAck failed");
        }
    }

    @Recover
    public void recover(Message message, Channel channel) throws IOException {
        log.info("start recover function");
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        log.error("go into dead-letter-queue");
    }

}
