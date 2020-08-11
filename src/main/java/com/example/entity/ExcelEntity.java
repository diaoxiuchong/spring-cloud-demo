package com.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: xiuchong
 * @Date: 2020/8/10 13:58
 * @Description:
 */
@Entity
@Getter
@Setter
public class ExcelEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(index = 0 , value = "工号")
    @Column(name = "staff_code")
    private Integer staffCode;
    @ExcelProperty(index = 1 , value = "姓名")
    @Column(name = "name")
    private String name;
    @ExcelProperty(index = 2 , value = "性别")
    @Column(name = "sex")
    private String sex;
    @ExcelProperty(index = 3 , value = "联系电话")
    @Column(name = "tel")
    private String tel;
    @ExcelProperty(index = 4 , value = "邮箱")
    @Column(name = "email")
    private String email;
    @ExcelProperty(index = 5 , value = "微信号")
    @Column(name = "weixin")
    private String weixin;
    @ExcelProperty(index = 6 , value = "部门")
    @Column(name = "department_id")
    private String departmentId;
    @ExcelProperty(index = 7 , value = "职位")
    @Column(name = "position_id")
    private String positionId;

    @Override
    public String toString() {
        return "ExcelEntity{" +
                "staffCode=" + staffCode +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", weixin='" + weixin + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", positionId='" + positionId + '\'' +
                '}';
    }
}
