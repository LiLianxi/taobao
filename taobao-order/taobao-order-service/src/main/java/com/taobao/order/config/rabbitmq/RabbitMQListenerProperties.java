package com.taobao.order.config.rabbitmq;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:30 PM
 */
@ConfigurationProperties(prefix = "spring.rabbitmq.listener.simple")
public class RabbitMQListenerProperties {

    private Integer concurrency;

    private Integer maxConcurrency;

    private Integer prefetch;

    public Integer getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(Integer concurrency) {
        this.concurrency = concurrency;
    }

    public Integer getMaxConcurrency() {
        return maxConcurrency;
    }

    public void setMaxConcurrency(Integer maxConcurrency) {
        this.maxConcurrency = maxConcurrency;
    }

    public Integer getPrefetch() {
        return prefetch;
    }

    public void setPrefetch(Integer prefetch) {
        this.prefetch = prefetch;
    }
}