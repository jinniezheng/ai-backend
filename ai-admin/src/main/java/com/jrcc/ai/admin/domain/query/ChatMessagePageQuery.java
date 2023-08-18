package com.jrcc.ai.admin.domain.query;

import com.jrcc.ai.base.domain.query.PageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hncboy
 * @date 2023-3-27
 * 聊天记录分页查询
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(title = "聊天记录分页查询")
public class ChatMessagePageQuery extends PageQuery {

    @Schema(title = "聊天室 id")
    private Long chatRoomId;

    @Size(max = 20, message = "ip 字数不能超过 20")
    @Schema(title = "ip")
    private String ip;

    @Size(max = 20, message = "问题或回复搜索字数字数不能超过20")
    @Schema(title = "问题或回复模糊搜索")
    private String content;
}
