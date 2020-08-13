package com.example.controller;

import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author: xiuchong
 * @Date: 2020/8/13 14:43
 * @Description: 使用BaseController将解析的内容存储一下
 * 一个请求访问进行访问的顺序是，拦截器 -> @ModelAttribute修饰的方法 -> 业务处理的controller,
 * 所以在这里我们定义BaseController，写入@ModelAttribute 来统一解析token，
 * 后继需要进行token解析的controller，都继承这个类。
 */
public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String UserId;  // 用户id
    protected String authority;  // 用户权限

    @ModelAttribute
    public void parseClaims(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        // 获取到在拦截器里设置的 user_claims， 并将其保存到类的成员变量中
        Claims userClaims = (Claims) request.getAttribute("user_claims");
        if(userClaims != null) {
            this.UserId = userClaims.getId();
            this.authority = userClaims.get("authority").toString();
        }
    }
}
