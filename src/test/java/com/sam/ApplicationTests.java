package com.sam;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    //@Test
    void contextLoads() {

        System.out.println("###############");
        int i = userMapper.deleteAll();
        System.out.println("delete表成功，清除条数：" + i);


    }

    @Test
    void truncate(){
        int i = userMapper.truncate();
        System.out.println("清空(truncate)表成功");
    }


    @Test
    void seed(){
        List<User> data = Arrays.asList(
                new User(1,"刘备", 58),
                new User(2,"关羽", 55),
                new User(3,"张飞", 51),
                new User(4,"赵云", 38),
                new User(5,"黄忠", 70),
                new User(6,"马超", 32),
                new User(7,"孔明", 50),
                new User(8,"糜夫人", 57),
                new User(9,"孙夫人", 32),
                new User(10,"阿斗", 22),
                new User(11,"曹操", 58),
                new User(12,"许褚", 58),
                new User(13,"荀彧", 58),
                new User(14,"张辽", 58),
                new User(15,"曹丕", 30)
        );

        for(User user:data){
            userMapper.insert(user);
        }

    }

    @Test
    void  unSeed(){
        User u = new User("曹丕",30);
        QueryWrapper<User> wrapper = new QueryWrapper<>(u);
        userMapper.delete(wrapper);

        //List<User> users = userMapper.selectList(wrapper);
        //for(User user:users){
        //
        //}
    }

    @Test
    void  selectMC(){
        System.out.println("test seed ######");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",32);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
        //users.forEach(System.out::println);
    }

}
