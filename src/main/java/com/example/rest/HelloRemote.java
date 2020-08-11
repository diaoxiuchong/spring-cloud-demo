package com.example.rest;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: xiuchong
 * @Date: 2020/8/6 15:03
 * @Description:
 */

//@FeignClient(name= "spring-cloud-two")
public interface HelloRemote {

    //这个接口要和远程调用的接口，参数，接口名，返回类型 一致
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    String find();


}
