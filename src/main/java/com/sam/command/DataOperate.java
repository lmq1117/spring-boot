package com.sam.command;

import com.sam.service.HelloService;
import com.sam.service.impl.HelloServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.sam.dao")
public class DataOperate {

    @Autowired
    static HelloService helloService;

    public static void main(String[] args) {
        ConfigurableApplicationContext dataOpt = SpringApplication.run(DataOperate.class, args);

        System.out.println("fdasfdsafd");

        //System.out.println();

        //HelloServiceImpl helloService = new HelloServiceImpl();
        //helloService.hello();
        //helloService.hello();

        dataOpt.close();
    }
}
