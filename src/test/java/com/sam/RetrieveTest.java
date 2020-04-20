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
        //DEBUG==>  Preparing: SELECT id,name,age,email,manager_id,create_time FROM user WHERE id=?
        //DEBUG==> Parameters: 1088248166370832385(Long)
        //TRACE<==    Columns: id, name, age, email, manager_id, create_time
        //TRACE<==        Row: 1088248166370832385, 王天风, 25, wtf@baomidou.com, 1087982257332887553, 2019-02-05 11:12:22
        //DEBUG<==      Total: 1

        User user = userMapper.selectById(1088248166370832385L);
        System.out.println(user);

    }

    @Test
    void selectByIds() {
        List<Long> ids = Arrays.asList(1087982257332887553L,1088248166370832385L,1094590409767661570L);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);
    }


    @Test
    public void selectByMap(){
        Map<String,Object> columnMap = new HashMap<>();//菱形语法
        //columnMap.put("name","王天风");
        columnMap.put("age","31");
       List<User> users =  userMapper.selectByMap(columnMap);
        users.forEach(System.out::println);
    }

}
