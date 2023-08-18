package com.jrcc.ai.base.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.jrcc.ai.base.enums.UserExtraBindingTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author jinxin
 * @description TODO
 * @date 2023-07-18 14:00
 */
@TableName(value = "front_user_extra_binding")
@Data
public class FrontUserExtraBindingDO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 绑定类型
     */
    private UserExtraBindingTypeEnum bindingType;

    /**
     * 额外信息表的用户ID
     */
    private Integer extraInfoId;

    /**
     * 基础用户表的ID
     */
    private Integer baseUserId;

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
