package com.jrcc.ai.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrcc.ai.admin.domain.query.ChatRoomPageQuery;
import com.jrcc.ai.admin.domain.vo.ChatRoomVO;
import com.jrcc.ai.admin.service.ChatRoomService;
import com.jrcc.ai.base.annotation.ApiAdminRestController;
import com.jrcc.ai.base.handler.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author hncboy
 * @date 2023-3-27
 * 聊天室相关接口
 */
@AllArgsConstructor
@Tag(name = "管理端-聊天室相关接口")
@ApiAdminRestController("/chat_room")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @Operation(summary = "聊天室分页列表")
    @PostMapping("/page")
    public R<IPage<ChatRoomVO>> page(@Validated @RequestBody ChatRoomPageQuery chatRoomPageQuery) {
        return R.data(chatRoomService.pageChatRoom(chatRoomPageQuery));
    }
}
