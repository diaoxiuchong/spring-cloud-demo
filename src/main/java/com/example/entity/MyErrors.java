package com.example.entity;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者:杨洋
 * 版本:1.6
 * 位置:我的风格包
 * 错误码枚举大全
 * Created by yangyang on 2018/8/1
 * 增加部分错误信息
 * Update by yangyang on 2018/8/18.
 * 增加部分错误信息
 * Update by yangyang on 2018/9/1.
 * 去掉了没用的get/set方法
 * Update by yangyang on 2018/9/8.
 * 增加部分错误信息, 修改一些错误信息, 使其更符合http协议风格.
 * Update by yangyang on 2018/10/18.
 * 增加数值类相关错误信息
 * Update by yangyang on 2018/11/16.
 * 增加可以按code取对应枚举的方法.
 * Update by yangyang on 2019/6/18.
 */

public enum MyErrors {

    //***** 服务器 API相关 *****
    OK("200", "成功"),
    FAIL("404", "失败"),
    ERROR("500", "服务器错误"),
    API_ERROR("1501", "接口不存在或访问方式错误！"),

    //***** 入参相关 *****
    PARAM_ERROR("2000", "参数错误"),
    PARAM_FORMAT_ERROR("2001", "参数格式错误"),
    PARAM_LACK_ERROR("2002", "缺少参数"),
    PHONE_ERROR("5001", "请填入正确的手机号"),

    //***** 课程相关 *****
    COURSE_NOT_EXIST("100001", "课程不存在"),
    COURSE_ALREADY_HAS("100002", "该课程您已购买，请勿重复购买"),

    //***** 俱乐部相关 *****
    CLUB_NOT_EXIST("200001", "俱乐部不存在"),

    //***** 学员相关 *****
    IDCARD_AND_PHONE_NOT_MATCH("300001", "该身份证与手机号不匹配，请咨询老师XXXX"),
    IDCARD_AND_NAME_NOT_MATCH("300002", "身份证实名校验未通过"),
    CONSUMERUSER_NOT_EXIST("300003", "用户不存在"),
    ROLE_ALREADY_USED("300004", "角色已被使用，无法删除"),

    //***** 俱乐部相关 *****
    SPORTSYSTEM_NOT_EXIST("400001","所属运动体系不存在，请先新建"),
    //***** 618论坛报名相关 *****
    CONSUMERUSER_EXIST("500001","您报名已完成，请勿重复报名"),
    APPLY_NOT_EXIST("500002","该报名不存在"),

    GETACCESSTOKEN_FAIL("500003","获取AccessToken失败"),

    ;

    public String errorCode;
    public String errorMsg;


    MyErrors(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    private static final Map<String, MyErrors> lookup = new HashMap<>();

    static {
        for (MyErrors s : EnumSet.allOf(MyErrors.class)) {
            lookup.put(s.errorCode, s);
        }
    }

    public static MyErrors get(String errorCode) {
        return lookup.get(errorCode);
    }
}