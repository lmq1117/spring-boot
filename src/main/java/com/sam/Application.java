package com.sam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

import static java.lang.System.exit;

@SpringBootApplication
@MapperScan("com.sam.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    //@Override
    //@Order(3)
    //public void run(String... args){
    //    if(args.length > 0){
    //        System.out.println("hello "+ args[0].toString());
    //    } else{
    //        System.out.println("hello3 world");
    //    }
    //    //exit(0);
    //}

}
