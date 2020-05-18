package com.sam.controller;

import com.sam.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloServiceImpl helloServiceImpl;

    @GetMapping("/hello")
    public String hello(){
        helloServiceImpl.hello();
         return "aa";

    }
}
