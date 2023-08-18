package com.jrcc.ai.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jrcc.ai.base.domain.entity.FrontUserBaseDO;
import com.jrcc.ai.base.domain.entity.FrontUserExtraBindingDO;
import com.jrcc.ai.base.domain.entity.FrontUserExtraEmailDO;
import com.jrcc.ai.base.enums.FrontUserRegisterTypeEnum;
import com.jrcc.ai.base.enums.UserExtraBindingTypeEnum;
import com.jrcc.ai.base.mapper.FrontUserExtraBindingMapper;
import com.jrcc.ai.front.service.FrontUserExtraBindingService;
import org.springframework.stereotype.Service;

/**
 * 前端用户绑定相关业务实现类
 *
 * @author CoDeleven
 */
@Service
public class FrontUserExtraBindingServiceImpl extends ServiceImpl<FrontUserExtraBindingMapper, FrontUserExtraBindingDO>
        implements FrontUserExtraBindingService {

    @Override
    public void bindEmail(FrontUserBaseDO baseUser, FrontUserExtraEmailDO extraEmailDO) {
        FrontUserExtraBindingDO bindingDO = new FrontUserExtraBindingDO();
        bindingDO.setBindingType(UserExtraBindingTypeEnum.BIND_EMAIL);
        bindingDO.setExtraInfoId(extraEmailDO.getId());
        bindingDO.setBaseUserId(baseUser.getId());
        this.save(bindingDO);
    }

    @Override
    public FrontUserExtraBindingDO findExtraBinding(FrontUserRegisterTypeEnum registerType, Integer extraInfoId) {
        return getOne(new LambdaQueryWrapper<FrontUserExtraBindingDO>()
                .eq(FrontUserExtraBindingDO::getBindingType, registerType)
                .eq(FrontUserExtraBindingDO::getExtraInfoId, extraInfoId));
    }
}




