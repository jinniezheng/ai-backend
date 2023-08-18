package com.jrcc.ai.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jrcc.ai.base.domain.entity.ChatMessageDO;
import com.jrcc.ai.base.enums.ApiTypeEnum;
import com.jrcc.ai.front.domain.request.ChatProcessRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 * @author jinxin
 * @date 2023-3-25
 * 聊天记录相关业务接口
 */
public interface ChatMessageService extends IService<ChatMessageDO> {

    /**
     * 消息处理
     *
     * @param chatProcessRequest 消息处理请求参数
     * @return emitter
     */
    ResponseBodyEmitter sendMessage(ChatProcessRequest chatProcessRequest);

    /**
     * 初始化聊天消息
     *
     * @param chatProcessRequest 消息处理请求参数
     * @param apiTypeEnum        API 类型
     * @return 聊天消息
     */
    ChatMessageDO initChatMessage(ChatProcessRequest chatProcessRequest, ApiTypeEnum apiTypeEnum);
}
