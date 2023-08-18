package com.jrcc.ai.base.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForStateless;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import com.jrcc.ai.base.util.StpAdminUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jinxin
 * @description TODO
 * @date 2023-07-18 14:03
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> {
                    // 管理端接口都必须管理端登录
                    SaRouter.match("/admin/**").check(r -> StpAdminUtil.checkLogin());
                    // 非管理端接口都必须 front 用户登录
                    SaRouter.notMatch("/admin/**").check(r -> StpUtil.checkLogin());
                }))
                // 放行管理端登录接口
                .excludePathPatterns("/admin/sys_user/login")
                // 放行用户端校验邮箱验证码
                .excludePathPatterns("/user/verify_email_code")
                // 放行用户端邮箱注册
                .excludePathPatterns("/user/register/email")
                // 放行用户端图形验证码
                .excludePathPatterns("/user/get_pic_code")
                // 放行用户端邮箱登录
                .excludePathPatterns("/user/login/email")
                // swagger 放行
                .excludePathPatterns("/swagger-ui/**")
                .excludePathPatterns("/v3/api-docs/**");
    }

    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForStateless();
    }
}
