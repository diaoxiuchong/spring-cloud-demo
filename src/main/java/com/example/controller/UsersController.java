package com.example.controller;

import com.example.common.JwtUtils;
import com.example.config.NoNeedToken;
import com.example.entity.Users;
import com.example.service.UsersService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: xiuchong
 * @Date: 2020/8/13 14:45
 * @Description:
 */
@RestController
public class UsersController extends BaseController{
    @Resource
    UsersService usersService; // 提供查询功能，根据用户nick查询到用户

    @Resource
    JwtUtils jwtUtils;

    // 用户登录方法
    @PostMapping(value = "/login")
    @NoNeedToken // 用于取消token验证
    public String login(@RequestBody Map<String, String> arg){
        String token = "";
        if(arg.get("nick")!= null){
            Users user = usersService.getPassByNick(arg.get("nick"));
            if(user.getPassword()!=null && user.getPassword().equals(arg.get("password"))){
                Map<String, Object> jwtArg = new HashMap<>();
                jwtArg.put("authority",user.getAuthority());
                System.out.println("" + user.getId().toString() +  user.getNick());
                token = jwtUtils.generateToken(user.getId().toString(), user.getNick(), jwtArg);
            }
        }
        return token;
    }
    // 获取用户信息方法
    @GetMapping(value = "/test")
    public Map<String, String> test(){
        Map<String, String> res = new HashMap<>();
        res.put("userID", this.UserId);  // 这里可以用this.UserId是继承了BaseController
        res.put("authority",this.authority);
        return res;
    }
}
