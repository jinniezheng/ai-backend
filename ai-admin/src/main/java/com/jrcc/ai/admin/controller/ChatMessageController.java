package com.jrcc.ai.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrcc.ai.admin.domain.query.ChatMessagePageQuery;
import com.jrcc.ai.admin.domain.vo.ChatMessageVO;
import com.jrcc.ai.admin.service.ChatMessageService;
import com.jrcc.ai.base.annotation.ApiAdminRestController;
import com.jrcc.ai.base.handler.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author hncboy
 * @date 2023-3-27
 * 聊天记录相关接口
 */
@AllArgsConstructor
@Tag(name = "管理端-聊天记录相关接口")
@ApiAdminRestController("/chat_message")
public class ChatMessageController {

    @Resource
    private final ChatMessageService chatMessageService;

    @Operation(summary = "分页列表")
    @PostMapping("/page")
    public R<IPage<ChatMessageVO>> page(@Validated @RequestBody ChatMessagePageQuery chatMessagePageQuery) {
        return R.data(chatMessageService.pageChatMessage(chatMessagePageQuery));
    }
}
