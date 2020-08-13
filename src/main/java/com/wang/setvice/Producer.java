package com.wang.setvice;

import com.wang.po.Message;

/**
 * @author zkr.wangzm
 * 生产者提供消息
 */

public interface Producer {
    /**
     * 发送消息
     * @param queue
     * @param message
     */
    public void sendMessage(String queue, Message message);//向队列queue发送消息
}
