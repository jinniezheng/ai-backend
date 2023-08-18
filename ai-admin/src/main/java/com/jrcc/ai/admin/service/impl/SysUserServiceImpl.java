package com.jrcc.ai.admin.service.impl;

import com.jrcc.ai.admin.domain.request.SysUserLoginRequest;
import com.jrcc.ai.admin.service.SysUserService;
import com.jrcc.ai.base.config.ChatConfig;
import com.jrcc.ai.base.exception.AuthException;
import com.jrcc.ai.base.util.StpAdminUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author hncboy
 * @date 2023-3-28
 * 系统用户业务实现类
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private ChatConfig chatConfig;

    @Override
    public void login(SysUserLoginRequest sysUserLoginRequest) {
        if (sysUserLoginRequest.getAccount().equals(chatConfig.getAdminAccount()) && sysUserLoginRequest.getPassword().equals(chatConfig.getAdminPassword())) {
            StpAdminUtil.login(sysUserLoginRequest.getAccount());
            return;
        }
        throw new AuthException("账号或密码错误");
    }
}
