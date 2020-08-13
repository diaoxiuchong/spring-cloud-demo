package com.example.config;

import java.lang.annotation.*;



/**
 * @Author: xiuchong
 * @Date: 2020/8/13 14:34
 * @Description: 定义免token访问的注解
 */
@Target({ElementType.METHOD, ElementType.TYPE}) //注解的范围是类、接口、枚举的方法上
@Retention(RetentionPolicy.RUNTIME)//被虚拟机保存，可用反射机制读取
@Documented
public @interface NoNeedToken {
}
