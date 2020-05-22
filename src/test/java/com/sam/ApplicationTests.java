package com.sam;

import com.sam.mapper.UserMapper;
import com.sam.pojo.User;
import com.sam.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationTests {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void getUserList() {
        userMapper.getUserList().forEach(System.out::println);
    }

    /**
     * 测试自定义的插入方法  insertUser(user)
     */
    @Test
    void insertUserTest() {
        User user = new User(19L, "王小二", 20, "xiaoer@qq.com");
        int rows = userMapper.insertUser(user);
        System.out.println("影响行数是：" + rows);
    }

    @Test
    void insertUserTest2() {
        User user = new User("王小三", 20, "xiaoer@qq.com");
        int rows = userMapper.insertUser(user);
        System.out.println("影响行数是：" + rows);
    }

    @Test
    void saveUserServiceTest(){
        User user = new User("阿黄", 20, "ahuang@qq.com");
        boolean b = userService.saveUserService(user);
        if(b){
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

}
