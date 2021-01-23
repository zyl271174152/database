package com.zyl.database.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author zhuyanli
 * @date 2021/1/18 16:17
 * @description 工单表
 */

@Data
@TableName(value = "work_order")
public class WorkOrder {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long companyId;
    /**
     * 应用名字
     */
    private String applicationName;

    /**
     * 工单类型1.功能异常 2. 体验问题 3. 产品建议
     */
    private String type;
    /**
     * 工单状态
     */
    private Integer workStatus;

    /**
     * 用户表主键id关联
     */
    private Long userInfoId;


    /**
     * 所属店仓id
     */
    private Long storeId;

    /**
     * 问题描述
     */
    private String descrption;
    /**
     * 申请工单人姓名
     */
    private String applicant;
    /**
     * 申请人手机
     */
    private String applicantMobile;


}
