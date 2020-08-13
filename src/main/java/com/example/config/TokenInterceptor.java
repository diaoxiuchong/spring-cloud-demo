package com.example.config;

import com.alibaba.fastjson.JSONObject;
import com.example.common.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: xiuchong
 * @Date: 2020/8/13 14:32
 * @Description: 定义拦截器
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    // 自动注入一下
    @Resource
    private JwtUtils jwtUtils;
    // 这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置返回值属性
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String token = request.getHeader("token");
        //String requestURI = request.getRequestURI();
        PrintWriter out;
       /* if(requestURI.startsWith("/login")){
            return true;
        }*/
        // 对于注解的判断
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(handlerMethod.getMethodAnnotation(NoNeedToken.class)!=null || handlerMethod.getBeanType().isAnnotationPresent(NoNeedToken.class)){
            // 如果自己拥有NoNeedToken标注或者所属的class拥有NoNeedToken 就直接放行
            return true;
        }
        // 在这里写你的判断逻辑 return true是通过拦截器，可以继续访问controller，return false是不通过
        if (token != null) {
            Claims claims = null;
            try{
                claims = jwtUtils.parseToken(token);
            }catch (Exception ignored){
            }
            if(claims != null){
                request.setAttribute("user_claims", claims);
                return true;
            }
        }
        JSONObject res = new JSONObject();
        res.put("state","false");
        res.put("msg","token is null or wrong");
        out = response.getWriter();
        out.append(res.toString());
        return false;
    }
}
