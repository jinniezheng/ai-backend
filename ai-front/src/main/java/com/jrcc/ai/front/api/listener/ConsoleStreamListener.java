package com.jrcc.ai.front.api.listener;

import com.jrcc.ai.front.domain.vo.ChatReplyMessageVO;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;

/**
 * @author jinxin
 * @date 2023-3-24
 * 控制台消息流监听
 */
public class ConsoleStreamListener extends AbstractStreamListener {

    @Override
    public void onMessage(String newMessage, String receivedMessage, ChatReplyMessageVO chatReplyMessageVO, int i) {
        System.out.println(newMessage);
    }

    @Override
    public void onError(String receivedMessage, Throwable t, @Nullable Response response) {
        System.out.println("控制台消息输出异常了");
    }
}
