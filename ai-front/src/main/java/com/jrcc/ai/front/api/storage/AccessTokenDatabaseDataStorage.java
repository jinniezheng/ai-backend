package com.jrcc.ai.front.api.storage;

import com.jrcc.ai.base.domain.entity.ChatMessageDO;
import com.jrcc.ai.front.api.accesstoken.ConversationResponse;
import org.springframework.stereotype.Component;

/**
 * @author jinxin
 * @date 2023-3-25
 * AccessToken 数据库数据存储
 */
@Component
public class AccessTokenDatabaseDataStorage extends AbstractDatabaseDataStorage {

    @Override
    public void onFirstMessage(ChatMessageStorage chatMessageStorage) {
        // 第一条消息
        ConversationResponse conversationResponse = (ConversationResponse) chatMessageStorage.getParser().
                parseSuccess(chatMessageStorage.getOriginalResponseData());
        ConversationResponse.Message message = conversationResponse.getMessage();

        // 第一条消息填充对话 id 和消息 id
        ChatMessageDO answerChatMessageDO = chatMessageStorage.getAnswerChatMessageDO();
        answerChatMessageDO.setMessageId(message.getId());
        answerChatMessageDO.setConversationId(conversationResponse.getConversationId());

        // 填充问题消息的对话 id
        chatMessageStorage.getQuestionChatMessageDO().setConversationId(conversationResponse.getConversationId());
    }

    @Override
    void onLastMessage(ChatMessageStorage chatMessageStorage) {

    }

    @Override
    void onErrorMessage(ChatMessageStorage chatMessageStorage) {

    }
}
