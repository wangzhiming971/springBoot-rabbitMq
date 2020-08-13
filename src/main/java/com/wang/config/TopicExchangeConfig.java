package com.wang.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zkr.wangzm
 *topic交换机模型，需要一个topic交换机，两个队列和三个binding
 */
@Configuration
public class TopicExchangeConfig {
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic");
    }

    @Bean
    public Queue topicQueue(){
        return  new Queue("topicQueue");
    }

    @Bean
    public Queue topicQueue1(){
        return  new Queue("topicQueue1");
    }

    @Bean
    public Binding bindingOrange(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("*.orange.*");
    }

    @Bean
    public Binding bindingBlack(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("*.*.black");
    }

    @Bean
    public Binding bindingGreen(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("#.green");
    }
}
