package com.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: xiuchong
 * @Date: 2020/8/13 14:50
 * @Description:
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @Column(length = 100)
    private String Id;

    private String nick;

    private String password;

    private String authority;


}
