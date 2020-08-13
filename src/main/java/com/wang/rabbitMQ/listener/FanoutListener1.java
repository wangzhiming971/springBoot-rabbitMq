package com.wang.rabbitMQ.listener;

import com.wang.po.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zkr.wangzm
 */
@Component
public class FanoutListener1 {
    @RabbitListener(queues = "fanoutQueue1")
    public void displayMessage(Message message){
        System.out.println("订阅者2队列监听器收到消息:" + message.toString());
    }
}
