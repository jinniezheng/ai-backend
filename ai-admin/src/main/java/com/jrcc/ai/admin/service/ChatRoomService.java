package com.jrcc.ai.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jrcc.ai.admin.domain.query.ChatRoomPageQuery;
import com.jrcc.ai.admin.domain.vo.ChatRoomVO;
import com.jrcc.ai.base.domain.entity.ChatRoomDO;

/**
 * @author hncboy
 * @date 2023-3-27
 * 聊天室相关业务接口
 */
public interface ChatRoomService extends IService<ChatRoomDO> {


    /**
     * 聊天室分页
     *
     * @param chatRoomPageQuery 查询参数
     * @return 聊天室展示参数
     */
    IPage<ChatRoomVO> pageChatRoom(ChatRoomPageQuery chatRoomPageQuery);
}
