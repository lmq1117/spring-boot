package com.sam.service;

import com.sam.dao.UserMapper;
import com.sam.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@MapperScan("com.sam.dao")
public class HelloService {
    @Autowired
    UserMapper userMapper;

    //private UserMapper userMapper;

    //HelloService(UserMapper userMapper){
    //    this.userMapper = userMapper;
    //}

    public void hello(){
        userMapper.insert(new User("小猫",23));
        userMapper.insert(new User("小花",25));
    }
}
