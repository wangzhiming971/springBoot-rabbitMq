package com.wang.setvice.impl;

import com.wang.po.Message;
import com.wang.setvice.Consumer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zkr.wangzm
 * 消费者具体实现类
 */
@Service("Consumer")
public class ConsumerImpl implements Consumer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 广播模式发送消息(fanout)
     * @param message
     */
    @Override
    public void publishMessage(Message message) {
        rabbitTemplate.convertAndSend("fanout",message);
    }

    /**
     * 直连模式发送消息(direct)
     * @param message
     * @param routingkey
     */
    @Override
    public void sendDirectMessage(Message message, String routingkey) {
        rabbitTemplate.convertAndSend("direct",routingkey,message);
    }

    /**
     * 发布订阅者模式发送消息(topic)
     * @param message
     * @param routingkey
     */
    @Override
    public void sendTopicMessage(Message message, String routingkey) {
        rabbitTemplate.convertAndSend("topic",routingkey,message);
    }
}
