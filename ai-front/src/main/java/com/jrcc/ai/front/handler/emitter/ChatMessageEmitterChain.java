package com.jrcc.ai.front.handler.emitter;

import cn.hutool.extra.spring.SpringUtil;
import com.jrcc.ai.base.config.ChatConfig;
import com.jrcc.ai.base.enums.ApiTypeEnum;
import com.jrcc.ai.front.domain.request.ChatProcessRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 * @author jinxin
 * @date 2023-3-29
 * 正常发送消息链路，最后一个节点
 */
public class ChatMessageEmitterChain extends AbstractResponseEmitterChain {

    @Override
    public void doChain(ChatProcessRequest request, ResponseBodyEmitter emitter) {
        ApiTypeEnum apiTypeEnum = SpringUtil.getBean(ChatConfig.class).getApiTypeEnum();
        ResponseEmitter responseEmitter;
        if (apiTypeEnum == ApiTypeEnum.API_KEY) {
            responseEmitter = SpringUtil.getBean(ApiKeyResponseEmitter.class);
        } else {
            responseEmitter = SpringUtil.getBean(AccessTokenResponseEmitter.class);
        }
        responseEmitter.requestToResponseEmitter(request, emitter);
    }
}
