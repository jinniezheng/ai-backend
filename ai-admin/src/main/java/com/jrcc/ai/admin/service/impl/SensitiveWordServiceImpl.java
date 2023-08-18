package com.jrcc.ai.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jrcc.ai.admin.domain.query.SensitiveWordPageQuery;
import com.jrcc.ai.admin.domain.vo.SensitiveWordVO;
import com.jrcc.ai.admin.handler.converter.SensitiveWordConverter;
import com.jrcc.ai.admin.service.SensitiveWordService;
import com.jrcc.ai.base.domain.entity.SensitiveWordDO;
import com.jrcc.ai.base.mapper.SensitiveWordMapper;
import com.jrcc.ai.base.util.PageUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author hncboy
 * @date 2023-3-28
 * 敏感词业务实现类
 */
@Service
public class SensitiveWordServiceImpl extends ServiceImpl<SensitiveWordMapper, SensitiveWordDO> implements SensitiveWordService {

    @Override
    public IPage<SensitiveWordVO> pageSensitiveWord(SensitiveWordPageQuery sensitiveWordPageQuery) {
        IPage<SensitiveWordDO> sensitiveWordPage = page(new Page<>(sensitiveWordPageQuery.getPageNum(), sensitiveWordPageQuery.getPageSize()),
                new LambdaQueryWrapper<SensitiveWordDO>()
                        .eq(Objects.nonNull(sensitiveWordPageQuery.getStatus()), SensitiveWordDO::getStatus, sensitiveWordPageQuery.getStatus())
                        .like(StrUtil.isNotBlank(sensitiveWordPageQuery.getWord()), SensitiveWordDO::getWord, sensitiveWordPageQuery.getWord())
                        .orderByDesc(SensitiveWordDO::getCreateTime));

        return PageUtil.toPage(sensitiveWordPage, SensitiveWordConverter.INSTANCE.entityToVO(sensitiveWordPage.getRecords()));
    }
}
