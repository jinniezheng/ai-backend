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
@TableName(value = "sys_email_send_log")
@Data
public class SysEmailSendLogDO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 发件人邮箱
     */
    private String fromEmailAddress;

    /**
     * 收件人邮箱
     */
    private String toEmailAddress;

    /**
     * 业务类型
     */
    private EmailBizTypeEnum bizType;

    /**
     * 请求 ip
     */
    private String requestIp;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 发送状态，0成功，1失败
     */
    private Integer status;

    /**
     * 发送内容
     */
    private String messageId;

    /**
     * 发送后的消息，用于记录成功/失败的信息，成功默认为 success
     */
    private String message;

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
