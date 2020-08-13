package com.wang.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Message implements Serializable {
    private static final long serialVersionUID = -8140693840257585779L;
    private  String messageId ;
    private  String messageInfo;
    private  Double count;
}
