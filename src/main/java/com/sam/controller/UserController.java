package com.sam.controller;

import com.sam.pojo.User;
import com.sam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "/home/user/login";
    }

    //@ResponseBody
    @PostMapping("/user/save")
    public String save(User user){
        boolean flag = userService.saveUserService(user);
        if (flag){
            return "home/user/list";
        } else {
            return "redirect:/home/to/error";
        }
    }

    @GetMapping("/user/save")
    public String userSave(){
        return "home/user/save";
    }

    @GetMapping("/user/list")
    public String userList(){
        User user = new User();
        return "home/user/list";
    }

    @GetMapping("/to/error")
    public String toError(){
        return "home/error/error";
    }
}
