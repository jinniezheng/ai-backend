package com.jrcc.ai.pay.service;

import com.jrcc.ai.pay.domain.ChatUserLimit;
import com.jrcc.ai.pay.domain.vo.ChatUserLimitVo;
import com.jrcc.ai.pay.domain.bo.ChatUserLimitBo;

import java.util.Collection;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ${author}
 * @date 2023-07-19
 */
public interface IChatUserLimitService {

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    ChatUserLimit queryById(Long id);

    /**
     * 查询【请填写功能名称】
     *
     * @param userId 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    ChatUserLimit queryByUserId(Long userId);

//    /**
//     * 查询【请填写功能名称】列表
//     *
//     * @param chatUserLimit 【请填写功能名称】
//     * @return 【请填写功能名称】集合
//     */
//    TableDataInfo<ChatUserLimitVo> queryPageList(ChatUserLimitBo bo, PageQuery pageQuery);
//
//    /**
//     * 查询【请填写功能名称】列表
//     *
//     * @param chatUserLimit 【请填写功能名称】
//     * @return 【请填写功能名称】集合
//     */
//    List<ChatUserLimitVo> queryList(ChatUserLimitBo bo);

    /**
     * 修改【请填写功能名称】
     *
     * @param bo 【请填写功能名称】
     * @return 结果
     */
    Boolean insertByBo(ChatUserLimitBo bo);

    /**
     * 修改【请填写功能名称】
     *
     * @param chatUserLimit 【请填写功能名称】
     * @return 结果
     */
    Boolean updateByBo(ChatUserLimitBo bo);

    /**
     * 校验并批量删除【请填写功能名称】信息
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @param isValid 是否校验,true-删除前校验,false-不校验
     * @return 结果
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
