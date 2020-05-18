package com.sam;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sam.dao.UserMapper;
import com.sam.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DataOpt {
    @Autowired UserMapper userMapper;

    @Test
    public void testSeed(){
        System.out.println("test seed ######");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",32);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
















    //public static void main(String[] args) {
    //    ConfigurableApplicationContext context = SpringApplication.run(DataOpt.class, args);
    //
    //    System.out.println("###DataOpt###");
    //    HelloService helloService = new HelloService();
    //    helloService.hello();
    //
    //
    //    context.close();
    //}
}
