package com.wang.rabbitMQ.listener;

import com.wang.po.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zkr.wangzm
 */
@Component
public class TopicListener1 {

    @RabbitListener(queues = "topicQueue1")
    public void displayMessage(Message message){
        System.out.println("topicQueue1取出消息:" + message.toString());
    }
}
