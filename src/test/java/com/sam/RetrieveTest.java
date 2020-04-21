package com.sam;

import com.sam.dao.UserMapper;
import com.sam.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)//可以在spring环境下运行juint测试
@SpringBootTest
class RetrieveTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    void selectById() {
        User user = userMapper.selectById(1088250446457389058L);
        System.out.println(user);
    }

    @Test
    void selectIds() {
        List<Long> ids = Arrays.asList(1088248166370832385L, 1094590409767661570L);
        List<User> users = userMapper.selectBatchIds(ids);
//        System.out.println(users);
        users.forEach(System.out::println);
    }

    @Test
    void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "王天风");
        map.put("age", 25);
        List<User> users = userMapper.selectByMap(map);

    }
}
