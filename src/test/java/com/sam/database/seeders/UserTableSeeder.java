//package com.sam.database.seeders;
//
//
//import com.sam.dao.UserMapper;
//import com.sam.entity.User;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class UserTableSeeder {
//
//    @Autowired
//    UserMapper userMapper;
//
//
//
//    //@Test
//    void seed2(){
//        List<User> data = Arrays.asList(
//                new User("刘备1", 58),
//                new User("关羽1", 55),
//                new User("张飞1", 51),
//                new User("赵云1", 38),
//                new User("黄忠1", 70),
//                new User("马超1", 32),
//                new User("孔明1", 50),
//                new User("糜夫人1", 57),
//                new User("孙夫人1", 32),
//                new User("阿斗1", 22),
//                new User("曹操1", 58),
//                new User("许褚1", 58),
//                new User("荀彧1", 58),
//                new User("张辽1", 58),
//                new User("曹丕1", 30)
//        );
//
//        for(User user:data){
//            userMapper.insert(user);
//        }
//
//    }
//}
