package com.sam.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class StartUpRunner2 implements CommandLineRunner {
    @Order(4)
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行4，执行加载数据等操作<<<<<<<<<<<<<");
    }
}
