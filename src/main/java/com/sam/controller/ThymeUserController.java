package com.sam.controller;

import com.sam.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试模板引擎的控制器
 * @author kevin
 * @date 2020/5/21
 */
@Controller
public class ThymeUserController {

    @GetMapping("/thyme.html")
    public String thymeData(Model model){
        User user = new User();
        user.setId(1);
        user.setName("sam");
        user.setAge(18);
        user.setEmail("sam@qq.com");
        model.addAttribute("user",user);
        return "home/thyme";
    }

    @GetMapping("/layout")
    public String thyme(){
        return "thymeleaf/testlayout/index";
    }
}
