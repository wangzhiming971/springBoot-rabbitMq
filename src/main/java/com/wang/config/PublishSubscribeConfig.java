package com.wang.config;

import com.wang.po.Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zkr.wangzm
 *发布订阅模式的配置,包括两个队列和对应的订阅者,发布者的交换机类型使用fanout(子网广播),两根网线binding用来绑定队列到交换机
 */
@Configuration
public class PublishSubscribeConfig {

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout");
    }

    @Bean
    public Queue fanoutQueue(){
        return new Queue("fanoutQueue");
    }

    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanoutQueue1");
    }

    @Bean
    public Binding binding1(){
        Binding binding =  BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
        return binding;
    }

    @Bean
    public Binding binding2(){
        Binding binding =  BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
        return binding;
    }


}
