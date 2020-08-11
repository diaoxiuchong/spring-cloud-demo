package com.example.controller;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.rest.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiuchong
 * @Date: 2020/8/6 15:05
 * @Description:
 */
@RestController
public class HelloController {

  /*  @Autowired
    private HelloRemote helloRemote;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    //@SentinelResource(value="hello")
    public String hello(){
        return helloRemote.find();
    }*/

}
