package com.wang.controller;

import com.wang.po.Message;
import com.wang.po.TopicMessage;
import com.wang.setvice.impl.ConsumerImpl;
import com.wang.setvice.impl.ProducerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zkr.wangzm
 */
@Controller
public class RabbitMqController {

    @Autowired
    ProducerImpl producer;

    @Autowired
    ConsumerImpl publisher;

    @RequestMapping(value = "/produce",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void produce(@ModelAttribute("message")Message message){
        producer.sendMessage("myqueue",message);
    }

    @RequestMapping(value = "/direct",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void  direct(@ModelAttribute("message") TopicMessage message){
        Message message1 = new Message(message.getMessageId(),message.getMessageInfo(),message.getCount());
        publisher.sendDirectMessage(message1,message.getRoutingkey());
    }

    @RequestMapping(value="/found",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void topic(@ModelAttribute("message") Message message){
        publisher.publishMessage(message);
    }

    @RequestMapping(value="/mytopic",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void topic(@ModelAttribute("message")TopicMessage message){
        Message message1 = new Message(message.getMessageId(),message.getMessageInfo(),message.getCount());
        publisher.sendTopicMessage(message1,message.getRoutingkey());
    }

    @RequestMapping("index")
    public String demo(){
        return "index";
    }
}
