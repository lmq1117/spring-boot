package com.sam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sam.mapper.UserMapper;
import com.sam.pojo.User;
import com.sam.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    public boolean saveUserService(User user){
        //User user = new User("阿黄", 20, "ahuang@qq.com");
        int count = baseMapper.insertUser(user);
        if(count > 0){
            return true;
        } else {
            return false;
        }
    }


    public List<User> getAllUser(){
        return baseMapper.getAllUser();
    }

    public boolean updateUser(User user){
        int count = baseMapper.updateUser(user);
        if(count > 0){
            return true;
        }
        return false;
    }

    public User getUserById(Integer id){
        return baseMapper.getUserById(id);
    }
}
