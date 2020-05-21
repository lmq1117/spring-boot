package com.sam;

import com.sam.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void getUserList() {
        userMapper.getUserList().forEach(System.out::println);
    }

}
