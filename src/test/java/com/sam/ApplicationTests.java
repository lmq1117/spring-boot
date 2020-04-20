package com.sam;

import com.sam.dao.UserMapper;
import com.sam.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)//可以在spring环境下运行juint测试
@SpringBootTest
class ApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> lists = userMapper.selectList(null);
        Assert.assertEquals(5, lists.size());
        lists.forEach(System.out::println);
    }

}
