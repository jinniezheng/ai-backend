package com.jrcc.ai.base.config;

import com.jrcc.ai.base.handler.serializer.DateFormatterSerializer;
import com.jrcc.ai.base.handler.serializer.LongToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Date;

/**
 * @author jinxin
 * @description TODO
 * @date 2023-07-18 14:01
 */
@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        // 返回 Long 转 String
        builder.serializerByType(Long.class, new LongToStringSerializer());
        // 返回 Date 格式化
        builder.serializerByType(Date.class, new DateFormatterSerializer());
        return builder;
    }
}
