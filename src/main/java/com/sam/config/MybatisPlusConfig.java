package com.sam.config;

import com.sam.utils.mpp.inject.MyMethodInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    /**
     * 自定义sql注入器
     * @return
     */
    @Bean
    public MyMethodInjector myMethodInjector(){
        return new MyMethodInjector();
    }

    //public PerformanceInterceptor performanceInterceptor(){
    //    return new Performance();
    //}
}
