package com.wang.rabbitMQ.listener;

import com.wang.po.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zkr.wangzm
 */
@Component
public class DirectListener {
    @RabbitListener(queues = "directQueue")
    public void displayMessage(Message message){
        System.out.println("directQueue队列监听器1号收到消息:" + message.toString());
    }
}
