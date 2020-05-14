package com.sam;

import com.sam.dao.UserMapper;
import com.sam.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        System.out.println("###############");
        int i = userMapper.deleteAll();
        System.out.println("delete表成功，清除条数：" + i);


    }

    @Test
    void truncate(){
        int i = userMapper.truncate();
        System.out.println("清空表成功，清除条数:"+i);
    }


    @Test
    void seed(){
        List<User> data = Arrays.asList(
                new User("刘备", 58),
                new User("关羽", 55),
                new User("张飞", 51),
                new User("赵云", 38),
                new User("黄忠", 70),
                new User("马超", 32),
                new User("孔明", 50),
                new User("糜夫人", 57),
                new User("孙夫人", 32),
                new User("阿斗", 22),
                new User("曹操", 58),
                new User("许褚", 58),
                new User("荀彧", 58),
                new User("张辽", 58),
                new User("曹丕", 30)
        );

        for(User user:data){
            userMapper.insert(user);
        }

    }

}
