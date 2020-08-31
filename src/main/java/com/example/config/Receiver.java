/*
package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

*/
/**
 * @Author: xiuchong
 * @Date: 2020-08-28 17:52
 * @Description:
 *//*

@Slf4j
@Component
@RabbitListener(queues = "message")
public class Receiver {

    @RabbitHandler
    public void process(String Str) {
        log.info("接收消息：" + Str);
        log.info("接收消息时间：" + new Date());
    }
}
*/
