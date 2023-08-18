package com.jrcc.ai.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jrcc.ai.base.domain.entity.SysFrontUserLoginLogDO;
import com.jrcc.ai.base.enums.FrontUserRegisterTypeEnum;
import com.jrcc.ai.base.mapper.SysFrontUserLoginLogMapper;
import com.jrcc.ai.base.util.WebUtil;
import com.jrcc.ai.front.service.FrontUserBaseService;
import com.jrcc.ai.front.service.SysFrontUserLoginLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前端用户登录日志业务实现类
 *
 * @author CoDeleven
 */
@Service
public class SysFrontUserLoginLogServiceImpl extends ServiceImpl<SysFrontUserLoginLogMapper, SysFrontUserLoginLogDO> implements SysFrontUserLoginLogService {

    @Resource
    private FrontUserBaseService frontUserBaseService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void loginFailed(FrontUserRegisterTypeEnum registerType, Integer extraInfoId, Integer baseUserId, String message) {
        SysFrontUserLoginLogDO logDO = new SysFrontUserLoginLogDO();
        logDO.setBaseUserId(baseUserId);
        logDO.setLoginExtraInfoId(extraInfoId);
        logDO.setLoginStatus(false);
        logDO.setLoginType(registerType);
        logDO.setMessage(message);
        logDO.setLoginIp(WebUtil.getIp());
        this.save(logDO);
    }

    @Override
    public void loginSuccess(FrontUserRegisterTypeEnum registerType, Integer extraInfoId, Integer baseUserId) {
        SysFrontUserLoginLogDO logDO = new SysFrontUserLoginLogDO();
        logDO.setBaseUserId(baseUserId);
        logDO.setLoginExtraInfoId(extraInfoId);
        logDO.setLoginStatus(true);
        logDO.setLoginType(registerType);
        logDO.setMessage("success");
        logDO.setLoginIp(WebUtil.getIp());
        this.save(logDO);

        // 更新上次登录时间
        frontUserBaseService.updateLastLoginIp(baseUserId);
    }
}




