package com.jrcc.ai.front.handler.emitter;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.StrUtil;
import com.jrcc.ai.base.handler.RateLimiterHandler;
import com.jrcc.ai.base.util.ObjectMapperUtil;
import com.jrcc.ai.base.util.WebUtil;
import com.jrcc.ai.front.domain.request.ChatProcessRequest;
import com.jrcc.ai.front.domain.vo.ChatReplyMessageVO;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;

/**
 * @author jinxin
 * Ip 限流处理
 */
@AllArgsConstructor
public class IpRateLimiterEmitterChain extends AbstractResponseEmitterChain {

    @Override
    public void doChain(ChatProcessRequest request, ResponseBodyEmitter emitter) {
        try {
            String ip = WebUtil.getIp();
            // 根据ip判断是够可放行
            Pair<Boolean, String> limitPair = RateLimiterHandler.allowRequest(ip);
            if (limitPair.getKey()) {
                if (getNext() != null) {
                    getNext().doChain(request, emitter);
                }
            } else {
                ChatReplyMessageVO chatReplyMessageVO = ChatReplyMessageVO.onEmitterChainException(request);
                chatReplyMessageVO.setText(StrUtil.format("当前访问人数过多，请等到 {} 后再尝试下", limitPair.getValue()));
                emitter.send(ObjectMapperUtil.toJson(chatReplyMessageVO));
                emitter.complete();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
