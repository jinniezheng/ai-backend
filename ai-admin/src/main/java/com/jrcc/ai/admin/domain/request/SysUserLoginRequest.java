package com.jrcc.ai.admin.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author hncboy
 * @date 2023-3-28
 * 系统用户登录参数
 */
@Schema(title = "系统用户登录参数")
@Data
public class SysUserLoginRequest {

    @NotNull(message = "账号不能为空")
    @Schema(title = "账号")
    private String account;

    @NotNull(message = "密码不能为空")
    @Schema(title = "密码")
    private String password;
}
