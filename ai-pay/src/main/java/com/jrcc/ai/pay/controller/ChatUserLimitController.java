package com.jrcc.ai.pay.controller;

import java.util.List;
import java.util.Arrays;

import com.jrcc.ai.base.handler.response.R;
import com.jrcc.ai.pay.domain.ChatUserLimit;
import com.jrcc.ai.pay.domain.vo.ChatUserLimitVo;
import com.jrcc.ai.pay.service.IChatUserLimitService;
import lombok.RequiredArgsConstructor;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

/**
 * 【请填写功能名称】Controller
 *
 * @author ${author}
 * @date 2023-07-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pay")
public class ChatUserLimitController {

    private final IChatUserLimitService iChatUserLimitService;

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping("/userId/{id}")
    public R<ChatUserLimit> getInfoByUserId(@PathVariable("id") Long userId) {
        return R.data(iChatUserLimitService.queryByUserId(userId));
    }

//    /**
//     * 新增【请填写功能名称】
//     */
//    @ApiOperation("新增【请填写功能名称】")
//    @SaCheckPermission("null:null:add")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
//    @RepeatSubmit()
//    @PostMapping()
//    public R<Void> add(@Validated(AddGroup.class) @RequestBody ChatUserLimitBo bo) {
//        return toAjax(iChatUserLimitService.insertByBo(bo) ? 1 : 0);
//    }
//
//    /**
//     * 修改【请填写功能名称】
//     */
//    @ApiOperation("修改【请填写功能名称】")
//    @SaCheckPermission("null:null:edit")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
//    @RepeatSubmit()
//    @PutMapping()
//    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ChatUserLimitBo bo) {
//        return toAjax(iChatUserLimitService.updateByBo(bo) ? 1 : 0);
//    }
//
//    /**
//     * 删除【请填写功能名称】
//     */
//    @ApiOperation("删除【请填写功能名称】")
//    @SaCheckPermission("null:null:remove")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
//    public R<Void> remove(@ApiParam("主键串")
//                                       @NotEmpty(message = "主键不能为空")
//                                       @PathVariable Long[] ids) {
//        return toAjax(iChatUserLimitService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
//    }
}
