package com.jrcc.ai.base.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author jinxin
 * @description TODO
 * @date 2023-07-18 14:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "front_user_base")
@Data
public class FrontUserBaseDO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户描述
     */
    private String description;

    /**
     * 头像版本
     */
    private Integer avatarVersion;

    /**
     * 上一次登录 IP
     */
    private String lastLoginIp;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
