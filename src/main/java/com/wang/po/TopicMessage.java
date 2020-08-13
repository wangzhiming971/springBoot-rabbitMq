package com.wang.po;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TopicMessage extends Message {

    private String routingkey;

}
