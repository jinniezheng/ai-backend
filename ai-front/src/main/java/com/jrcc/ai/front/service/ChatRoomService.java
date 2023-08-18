package com.jrcc.ai.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jrcc.ai.base.domain.entity.ChatMessageDO;
import com.jrcc.ai.base.domain.entity.ChatRoomDO;

/**
 * @author jinxin
 * @date 2023-3-25
 * 聊天室相关业务接口
 */
public interface ChatRoomService extends IService<ChatRoomDO> {

    /**
     * 创建聊天室
     *
     * @param chatMessageDO 聊天记录
     * @return 聊天室
     */
    ChatRoomDO createChatRoom(ChatMessageDO chatMessageDO);
}
