package com.jrcc.ai.pay.domain.bo;

import com.jrcc.ai.base.domain.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 【请填写功能名称】业务对象 chat_user_limit
 *
 * @author ${author}
 * @date 2023-07-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ChatUserLimitBo extends BaseEntity {

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
