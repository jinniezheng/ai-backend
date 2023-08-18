package com.jrcc.ai.admin.service;

import com.jrcc.ai.admin.domain.vo.RateLimitVO;

import java.util.List;

/**
 * @author hncboy
 * @date 2023-4-1
 * 限流记录业务接口
 */
public interface RateLimitService {

    /**
     * 查询限流列表
     *
     * @return 限流列表
     */
    List<RateLimitVO> listRateLimit();
}
