package com.jrcc.ai.pay.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jrcc.ai.pay.domain.ChatUserLimit;
import com.jrcc.ai.pay.domain.bo.ChatUserLimitBo;
import com.jrcc.ai.pay.mapper.ChatUserLimitMapper;
import com.jrcc.ai.pay.service.IChatUserLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ${author}
 * @date 2023-07-19
 */
@RequiredArgsConstructor
@Service
public class ChatUserLimitServiceImpl implements IChatUserLimitService {

    private final ChatUserLimitMapper baseMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ChatUserLimit queryById(Long id){
        return baseMapper.selectById(id);
    }

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ChatUserLimit queryByUserId(Long userId){
        LambdaQueryWrapper<ChatUserLimit> lqw = Wrappers.lambdaQuery();
        lqw.eq(ChatUserLimit::getUserId, userId);
        return baseMapper.selectOne(lqw);
    }

//    /**
//     * 查询【请填写功能名称】列表
//     *
//     * @param bo 【请填写功能名称】
//     * @return 【请填写功能名称】
//     */
//    @Override
//    public TableDataInfo<ChatUserLimitVo> queryPageList(ChatUserLimitBo bo, PageQuery pageQuery) {
//        LambdaQueryWrapper<ChatUserLimit> lqw = buildQueryWrapper(bo);
//        Page<ChatUserLimitVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
//        return TableDataInfo.build(result);
//    }
//
//    /**
//     * 查询【请填写功能名称】列表
//     *
//     * @param bo 【请填写功能名称】
//     * @return 【请填写功能名称】
//     */
//    @Override
//    public List<ChatUserLimitVo> queryList(ChatUserLimitBo bo) {
//        LambdaQueryWrapper<ChatUserLimit> lqw = buildQueryWrapper(bo);
//        return baseMapper.selectVoList(lqw);
//    }

    private LambdaQueryWrapper<ChatUserLimit> buildQueryWrapper(ChatUserLimitBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ChatUserLimit> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getUserId() != null, ChatUserLimit::getUserId, bo.getUserId());
        lqw.eq(bo.getLimitAmount() != null, ChatUserLimit::getLimitAmount, bo.getLimitAmount());
        lqw.eq(bo.getLimitTime() != null, ChatUserLimit::getLimitTime, bo.getLimitTime());
        return lqw;
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param bo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public Boolean insertByBo(ChatUserLimitBo bo) {
        ChatUserLimit add = BeanUtil.toBean(bo, ChatUserLimit.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param bo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public Boolean updateByBo(ChatUserLimitBo bo) {
        ChatUserLimit update = BeanUtil.toBean(bo, ChatUserLimit.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(ChatUserLimit entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
