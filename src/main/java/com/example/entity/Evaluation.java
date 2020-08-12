package com.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: shaobohuang
 * @Date: Create in 10:47 2020\7\8 0008
 */

@Getter
@Setter
@Entity
@Table(name = "evaluation")
@ApiModel("考评")
public class Evaluation extends EntityAuto{

    @Id
    @Column(length = 100)
    @ApiModelProperty("考评主键id")
    private String evaluationId;

    @ApiModelProperty("考评名称")
    private String evaluationName;

    @ApiModelProperty("所属考评体系")
    private String evaluationSystem;

    @ApiModelProperty("考评等级")
    private String evaluationLev;

    @ApiModelProperty("配图")
    private String evaluationPicture;

    @ApiModelProperty("考培简介")
    private String evaluationIntroduction;

    @ApiModelProperty("考评时间（开始）")
    private String evaluationStartTime;

    @ApiModelProperty("考评时间（结束）")
    private String evaluationEndTime;

    @ApiModelProperty("考评地点")
    private String evaluationPlace;

    @ApiModelProperty("考评员（以逗号分隔）")
    private String assessor;

    @ApiModelProperty("报名时间（开始）")
    private String registrationStartTime;

    @ApiModelProperty("报名时间（结束）")
    private String registrationEndTime;

    @ApiModelProperty("联系人")
    private String contacts;

    @ApiModelProperty("联系手机")
    private String contactsPhone;

    @ApiModelProperty("报名人数")
    private int registrationNum;

    @ApiModelProperty("考评状态,0:申请中;1:未通过;2:已挂起;3:等待报名;4:报名中;5:等待考评;6:考评中;7:已结束;8:删除;")
    private int status;

    @ApiModelProperty("审核状态,0:成绩未审核;1:成绩审批中;2:审批完成")
    private int examineStatus;

    @ApiModelProperty("失败原因")
    private String failureReasons ;

    @ApiModelProperty("所属考培机构")
    private String organizationId;

    @ApiModelProperty("上传成绩数")
    private int uploadNum;

    @ApiModelProperty("订单状态(0:未支付；1：支付成功)")
    private int payStatus;

    @ApiModelProperty("提交审批时间")
    private Date submitTime;

    @ApiModelProperty("审核数量")
    private int examineNum;
}
