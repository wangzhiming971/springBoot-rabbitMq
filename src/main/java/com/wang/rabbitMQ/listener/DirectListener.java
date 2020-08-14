package com.wang.rabbitmq.listener;

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
        System.out.println("directQueue:" + message.toString());
    }
}
