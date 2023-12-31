package com.jrcc.ai.admin.handler.converter;

import com.jrcc.ai.admin.domain.vo.ChatMessageVO;
import com.jrcc.ai.base.domain.entity.ChatMessageDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author hncboy
 * @date 2023-3-28
 * 聊天记录相关转换
 */
@Mapper
public interface ChatMessageConverter {

    ChatMessageConverter INSTANCE = Mappers.getMapper(ChatMessageConverter.class);

    /**
     * entityToVO
     *
     * @param chatMessageDOList chatMessageDOList
     * @return List<ChatMessageVO>
     */
    List<ChatMessageVO> entityToVO(List<ChatMessageDO> chatMessageDOList);
}
