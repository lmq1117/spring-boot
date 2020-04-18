package com.sam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping({"/","/hello"})
    public String hello(){
        return "hello";
    }

    @GetMapping({"/sam/hello2"})
    public String hello2(){
        return "hello2.sam";
    }

    @GetMapping({"/sam/hello3"})
    public String hello3(){
        return "hello3.sam";
    }

    @GetMapping("/kevin/hello4")
    public String hello4(){
        return "hello4.kevin";
    }
}
