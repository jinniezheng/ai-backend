package com.jrcc.ai.pay.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.jrcc.ai.base.domain.entity.BaseEntity;
import lombok.Data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 【请填写功能名称】对象 chat_user_limit
 *
 * @author ${author}
 * @date 2023-07-19
 */
@Data
@TableName("chat_user_limit")
public class ChatUserLimit extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     *
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 剩余次数
     */
    private Long limitAmount;
    /**
     * 到期时间
     */
    private Date limitTime;

}
