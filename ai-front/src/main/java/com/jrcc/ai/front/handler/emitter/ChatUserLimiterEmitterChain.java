package com.jrcc.ai.front.handler.emitter;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.StrUtil;
import com.jrcc.ai.base.handler.RateLimiterHandler;
import com.jrcc.ai.base.util.ObjectMapperUtil;
import com.jrcc.ai.base.util.StpAdminUtil;
import com.jrcc.ai.base.util.WebUtil;
import com.jrcc.ai.front.domain.request.ChatProcessRequest;
import com.jrcc.ai.front.domain.vo.ChatReplyMessageVO;
import com.jrcc.ai.pay.domain.ChatUserLimit;
import com.jrcc.ai.pay.domain.bo.ChatUserLimitBo;
import com.jrcc.ai.pay.service.IChatUserLimitService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.Date;

/**
 * @author jinxin
 * Ip 限流处理
 */
@AllArgsConstructor
public class ChatUserLimiterEmitterChain extends AbstractResponseEmitterChain {

    @Resource
    private IChatUserLimitService chatUserLimitService;

    @Override
    public void doChain(ChatProcessRequest request, ResponseBodyEmitter emitter) {
        try {
            Long userId = StpAdminUtil.getLoginIdAsLong();
            ChatUserLimit chatUserLimit = chatUserLimitService.queryByUserId(userId);
            // 判断用户是否包时间或者请求条数大于0
            Date now = new Date();
            int compare = chatUserLimit.getLimitTime().compareTo(now);
            if (compare > 0) {
                getNext().doChain(request, emitter);
            } else if (compare < 0 && chatUserLimit.getLimitAmount() > 0) {
                ChatUserLimitBo bo = BeanUtil.toBean(chatUserLimit, ChatUserLimitBo.class);
                bo.setLimitAmount(bo.getLimitAmount() - 1);
                chatUserLimitService.updateByBo(bo);
                getNext().doChain(request, emitter);
            } else {
                ChatReplyMessageVO chatReplyMessageVO = ChatReplyMessageVO.onEmitterChainException(request);
                chatReplyMessageVO.setText(StrUtil.format("您的账户没有额度，请充值"));
                emitter.send(ObjectMapperUtil.toJson(chatReplyMessageVO));
                emitter.complete();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
