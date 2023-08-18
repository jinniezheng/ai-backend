package com.jrcc.ai.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jrcc.ai.admin.domain.query.ChatMessagePageQuery;
import com.jrcc.ai.admin.domain.vo.ChatMessageVO;
import com.jrcc.ai.base.domain.entity.ChatMessageDO;

/**
 * @author hncboy
 * @date 2023-3-27
 * 聊天记录相关业务接口
 */
public interface ChatMessageService extends IService<ChatMessageDO> {

    /**
     * 聊天记录分页
     *
     * @param chatMessagePageQuery 查询参数
     * @return 聊天记录展示参数
     */
    IPage<ChatMessageVO> pageChatMessage(ChatMessagePageQuery chatMessagePageQuery);
}
