package com.wang.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zkr.wangzm
 */
@Configuration
public class ProducerConsumerConfig {
    @Bean
    public org.springframework.amqp.core.Queue myQueue() {
        Queue queue=new Queue("myqueue");
        return queue;
    }
}
