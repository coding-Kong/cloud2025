package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.util.retry.Retry;

/**
 * @author kdz
 * @create 2025-03-26-22:24
 */

@Configuration
public class FeignConfig {

    @Bean
    public Retryer myRetry() {

        //默认配置不走重试
        return Retryer.NEVER_RETRY;
        //最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
//        return new Retryer.Default(100,1,3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        //日志输出级别
        return Logger.Level.FULL;
    }
}
