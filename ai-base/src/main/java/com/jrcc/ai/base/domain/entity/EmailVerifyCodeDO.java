package com.jrcc.ai.base.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.jrcc.ai.base.enums.EmailBizTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author jinxin
 * @description TODO
 * @date 2023-07-18 14:00
 */
@TableName(value = "email_verify_code")
@Data
public class EmailVerifyCodeDO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 验证码接收邮箱地址
     */
    private String toEmailAddress;

    /**
     * 验证码唯一
     */
    private String verifyCode;

    /**
     * 是否使用，false 否，true 是
     */
    private Boolean isUsed;

    /**
     * 核销IP，方便识别一些机器人账号
     */
    private String verifyIp;

    /**
     * 验证码过期时间
     */
    private Date expireAt;

    /**
     * 当前邮箱业务
     */
    private EmailBizTypeEnum bizType;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
