package com.wang.rabbitmq.listener;

import com.wang.po.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zkr.wangzm
 */
@Component
public class QueueListener1 {
    @RabbitListener(queues = "myqueue")
    public void displayQueue(Message message){
        System.out.println("队列监听器2号接受到消息:"+message.toString());
    }
}
