package com.wang.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zkr.wangzm
 * 直连交换机配置
 * direct直连模式的交换机配置,包括一个direct交换机，两个队列，三根网线binding
 */
@Configuration
public class DirectExchangeConfig {
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct");
    }
    @Bean
    public Queue directQueue(){
        return  new Queue("directQueue");
    }

    @Bean
    public Queue directQueue1(){
        return  new Queue("directQueue1");
    }

    @Bean
    public Binding bindingOrange(){
        Binding binding=BindingBuilder.bind(directQueue()).to(directExchange()).with("orange");
        return binding;
    }

    @Bean
    public Binding bindingBlack(){
        Binding binding=BindingBuilder.bind(directQueue1()).to(directExchange()).with("black");
        return binding;
    }

    @Bean
    public Binding bindingGreen(){
        Binding binding=BindingBuilder.bind(directQueue1()).to(directExchange()).with("green");
        return binding;
    }
}
