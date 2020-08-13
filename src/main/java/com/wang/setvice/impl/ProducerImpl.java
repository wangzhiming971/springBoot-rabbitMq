package com.wang.setvice.impl;

import com.wang.po.Message;
import com.wang.setvice.Producer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zkr.wangzm
 * 生产者实现类
 */
@Service("Producer")
public class ProducerImpl implements Producer {
    @Autowired
    RabbitTemplate rabbitTemplate;
    /**
     * 生产者发送消息实现类
     * */
    @Override
    public void sendMessage(String queue, Message message) {
        rabbitTemplate.setQueue(queue);
        rabbitTemplate.convertAndSend(queue,message);
    }
}
