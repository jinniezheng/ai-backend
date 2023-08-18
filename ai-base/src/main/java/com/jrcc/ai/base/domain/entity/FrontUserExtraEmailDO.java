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
@TableName(value = "front_user_extra_email")
@Data
public class FrontUserExtraEmailDO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 邮箱账号
     */
    private String username;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 是否验证过，false 否 true 是
     */
    private Boolean verified;

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
