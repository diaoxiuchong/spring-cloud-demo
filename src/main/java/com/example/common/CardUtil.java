package com.example.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiuchong
 * @Date: 2020-11-06 14:20
 * @Description TODO 根据身份证号和获取用户年龄和性别和出生年月的工具类
 */
public class CardUtil {


    /**
     * 通过身份证号码获取出生日期、性别、年龄
     *
     * @param certificateNo
     * @return 返回的出生日期格式：1990-01-01   性别格式：F-女，M-男
     */
    public static Map<String, String> getBirAgeSex(String certificateNo) {
        String birthday = "";
        String age = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = certificateNo.toCharArray();
        boolean flag = true;
        if (number.length == 15) {
            for (int x = 0; x < number.length; x++) {
                if (!flag) return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        } else if (number.length == 18) {
            for (int x = 0; x < number.length - 1; x++) {
                if (!flag) return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        }
        if (flag && certificateNo.length() == 15) {
            birthday = "19" + certificateNo.substring(6, 8) + "-"
                    + certificateNo.substring(8, 10) + "-"
                    + certificateNo.substring(10, 12);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length())) % 2 == 0 ? "F" : "M";
            age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
        } else if (flag && certificateNo.length() == 18) {
            birthday = certificateNo.substring(6, 10) + "-"
                    + certificateNo.substring(10, 12) + "-"
                    + certificateNo.substring(12, 14);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1)) % 2 == 0 ? "F" : "M";
            age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("birthday", birthday);
        map.put("age", age);
        map.put("sexCode", sexCode);
        return map;
    }


    /**
     * 根据身份证的号码算出当前身份证持有者的性别和年龄 18位身份证
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getCarInfo(String CardCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        String year = CardCode.substring(6).substring(0, 4);// 得到年份
        String yue = CardCode.substring(10).substring(0, 2);// 得到月份
        // String day=CardCode.substring(12).substring(0,2);//得到日
        String sex;
        if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
            sex = "女";
        } else {
            sex = "男";
        }
        Date date = new Date();// 得到当前的系统时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fyear = format.format(date).substring(0, 4);// 当前年份
        String fyue = format.format(date).substring(5, 7);// 月份
        // String fday=format.format(date).substring(8,10);
        int age = 0;
        if (Integer.parseInt(yue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生
            age = Integer.parseInt(fyear) - Integer.parseInt(year) + 1;
        } else {// 当前用户还没过生
            age = Integer.parseInt(fyear) - Integer.parseInt(year);
        }
        map.put("sex", sex);
        map.put("age", age);
        return map;
    }

    /**
     * 15位身份证的验证
     *
     * @param
     * @throws Exception
     */
    public static Map<String, Object> getCarInfo15W(String card)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String uyear = "19" + card.substring(6, 8);// 年份
        String uyue = card.substring(8, 10);// 月份
        // String uday=card.substring(10, 12);//日
        String usex = card.substring(14, 15);// 用户的性别
        String sex;
        if (Integer.parseInt(usex) % 2 == 0) {
            sex = "女";
        } else {
            sex = "男";
        }
        Date date = new Date();// 得到当前的系统时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fyear = format.format(date).substring(0, 4);// 当前年份
        String fyue = format.format(date).substring(5, 7);// 月份
        // String fday=format.format(date).substring(8,10);
        int age = 0;
        if (Integer.parseInt(uyue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生
            age = Integer.parseInt(fyear) - Integer.parseInt(uyear) + 1;
        } else {// 当前用户还没过生
            age = Integer.parseInt(fyear) - Integer.parseInt(uyear);
        }
        map.put("sex", sex);
        map.put("age", age);
        return map;
    }
}
