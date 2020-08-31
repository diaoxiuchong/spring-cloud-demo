/*
package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;


*/
/**
 * @Author: xiuchong
 * @Date: 2020-08-28 17:45
 * @Description:
 *//*

@Slf4j
@Component
public class Sender {


    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(){
        String context = "简单消息发送";
        log.info("简单消息发送时间："+new Date());
        amqpTemplate.convertAndSend("message", context);
        return "发送成功";
    }

}
*/
