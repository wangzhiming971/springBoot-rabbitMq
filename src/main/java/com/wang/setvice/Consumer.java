package com.wang.setvice;

import com.wang.po.Message;

/**
 * @author zkr.wangzm
 * 消费者消费消息
 */

public interface Consumer {
    /**
     *使用fanout交换机发布消息给所有队列
     * @param message
     */
    public void publishMessage(Message message);

    /**
     * 使用direct交换机发送消息
     * @param message
     * @param routingkey
     */
    public void sendDirectMessage(Message message,String routingkey);

    /**
     * 使用topic交换机发送消息
     * @param message
     * @param routingkey
     */
    public void sendTopicMessage(Message message,String routingkey);
}
