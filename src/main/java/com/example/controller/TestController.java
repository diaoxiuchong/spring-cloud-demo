package com.example.controller;

import com.example.common.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: XCstyle
 * @Date: 2020-08-27 10:52
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/a")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/redis")
    public Object getRedis(){
        redisUtil.set("r","aaaaaa");
        redisUtil.hset("北体","事业部","刁秀崇");
        return redisUtil.get("r");
    }

}
