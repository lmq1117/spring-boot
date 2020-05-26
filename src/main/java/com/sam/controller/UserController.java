package com.sam.controller;

import com.sam.pojo.User;
import com.sam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

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
    public String save(User user, RedirectAttributes redirectAttributes){
        boolean flag = userService.saveUserService(user);
        if (flag){
            //set session
            redirectAttributes.addFlashAttribute("redirectMessage","保存成功");
            return "redirect:/home/user/get/all";
        } else {
            redirectAttributes.addFlashAttribute("redirectMessage","保存失败");
            return "redirect:/home/user/get/all";
            //return "redirect:/home/to/error";
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

    @GetMapping("/user/get/all")
    public String getAllUser(Model model,@ModelAttribute(value = "redirectMessage")String  redirectMessage){
        List<User> users = userService.getAllUser();
        model.addAttribute("users",users);
        model.addAttribute("redirectMessage",redirectMessage);
        System.out.println(redirectMessage);
        //model.addFlashAttribute();
        return "/home/user/list";
    }


    @GetMapping("/user/update/{id}")
    public String getUserById(@PathVariable("id") Integer id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "/home/user/update";
    }

    //@PostMapping("/user/update")
    //public String update(User user){
    //    User user = userService.getUserById(id);
    //    model.addAttribute("user",user);
    //    return "redirect:/home/user/get/all";
    //}


    @GetMapping("/to/error")
    public String toError(){
        return "home/error/error";
    }
}
