package com.jrcc.ai.base.exception;

import com.jrcc.ai.base.handler.response.IResultCode;
import com.jrcc.ai.base.handler.response.ResultCode;
import lombok.Getter;

/**
 * @author jinxin
 * @date 2023-3-23
 * 鉴权异常
 */
public class AuthException extends RuntimeException {

    @Getter
    private final IResultCode resultCode;

    public AuthException(String message) {
        super(message);
        this.resultCode = ResultCode.UN_AUTHORIZED;
    }
}
