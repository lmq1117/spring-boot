package com.sam.service.impl;

import com.sam.dao.UserMapper;
import com.sam.entity.User;
import com.sam.service.HelloService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@MapperScan("com.sam.dao")
public class HelloServiceImpl implements HelloService {
    @Autowired
    UserMapper userMapper;


    public void hello(){
        //userMapper.insert(new User("小猫",23));
        //userMapper.insert(new User("小花",25));
    }
}
