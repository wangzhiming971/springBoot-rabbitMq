package com.wang.rabbitMQ.listener;

import com.wang.po.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zkr.wangzm
 */
@Component
public class DirectListener1 {
    @RabbitListener(queues = "directQueue1")
    public void displayMessage(Message message){
        System.out.println("directQueue1队列监听器2号收到消息:" + message.toString());
    }
}
