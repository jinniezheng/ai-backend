package com.jrcc.ai.admin.service;

import com.jrcc.ai.admin.domain.request.SysUserLoginRequest;

/**
 * @author hncboy
 * @date 2023-3-28
 * 系统用户相关接口
 */
public interface SysUserService {

    /**
     * 登录
     *
     * @param sysUserLoginRequest 登录参数
     */
    void login(SysUserLoginRequest sysUserLoginRequest);
}
