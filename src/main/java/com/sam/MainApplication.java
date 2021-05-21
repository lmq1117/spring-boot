package com.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @SpringBootApplication
 * 等同于
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan("com.atguigu.boot") //更改根扫描包
 */


@SpringBootApplication
public class MainApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        String[] beanDefinitionNames = run.getBeanDefinitionNames();
    }
}
