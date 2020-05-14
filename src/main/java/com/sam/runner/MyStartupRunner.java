package com.sam.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyStartupRunner implements CommandLineRunner {
    @Order(2)
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行2，执行加载数据等操作<<<<<<<<<<<<<");
    }
}
