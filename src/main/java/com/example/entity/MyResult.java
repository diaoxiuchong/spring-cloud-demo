package com.example.entity;


/**
 * 作者:杨洋
 * 版本:1.5
 * 位置:我的风格包
 * 自制一个简洁好用的fluent风格的返回实体
 * Created by yangyang on 2018/9/1.
 * 进一步精简了代码,使其更接近java官方的代码风格
 * Update by yangyang on 2018/9/8.
 * 精简所有重复代码, 使构造方法全部基于复用原则.
 * Update by yangyang on 2018/9/10.
 * 取消Map格式的返回形式,减少数据层级.状态码和消息统一为框架的标准格式.
 * Update by yangyang on 2018/10/18.
 * 更换Object为T, 使swagger文档可以显示返回参数详情. 精简部分方法.
 * Update by yangyang on 2019/06/18.
 */
public class MyResult<T> {

    private String status;
    private String message;
    private String requestId;
    private Long total;//数据库中的总数 分页时使用
    private T      data;//要返回的数据


    public static MyResult ok() {
        return error(MyErrors.OK);
    }

    public static MyResult fail() {
        return error(MyErrors.FAIL);
    }


    public static MyResult ok(Object value) {
        return ok().setData(value);
    }


    public static MyResult ok(Object value, Long total) {
        return ok().setData(value).setTotal(total);
    }


    public static MyResult ok(Object value, Integer total) {
        return ok().setData(value).setTotal((long) total);
    }


    public static MyResult error(String message) {
        return error("-1", message);
    }


    public static MyResult error(MyErrors myErrors) {
        return error(myErrors.errorCode, myErrors.errorMsg);
    }


    public static MyResult error(String status, String message) {
        return new MyResult().setStatus(status).setMessage(message);
    }


    public String getStatus() {
        return status;
    }


    public MyResult setStatus(String status) {
        this.status = status;
        return this;
    }


    public String getMessage() {
        return message;
    }


    public MyResult setMessage(String message) {
        this.message = message;
        return this;
    }


    public T getData() {
        return data;
    }


    public MyResult setData(T data) {
        this.data = data;
        return this;
    }


    public Long getTotal() {
        return total;
    }


    public MyResult setTotal(Long total) {
        this.total = total;
        return this;
    }


    public String getRequestId() {
        return requestId;
    }


    public MyResult setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

}
