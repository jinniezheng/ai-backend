package com.jrcc.ai.pay.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


/**
 * 【请填写功能名称】视图对象 chat_user_limit
 *
 * @author ${author}
 * @date 2023-07-19
 */
@Data
public class ChatUserLimitVo {

    private static final long serialVersionUID = 1L;

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
