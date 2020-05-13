package com.sam;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sam.dao.StudentClassMapper;
import com.sam.dao.StudentMapper;
import com.sam.dao.UserMapper;
import com.sam.entity.Student;
import com.sam.entity.StudentClass;
import com.sam.entity.User;
import com.sam.service.LoadService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)//可以在spring环境下运行juint测试
@SpringBootTest
class LoadTest {
    /*
        selectById
        selectBatchIds
        selectByMap
     */

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;


    @Autowired
    private StudentClassMapper studentClassMapper;

    @Test
    void selectById() {
        Student student = studentMapper.selectById(1);
        System.out.println(student);
    }

    @Test
    void selectIds() {
        List<Long> ids = Arrays.asList(1088248166370832385L, 1094590409767661570L);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);
    }


    @Test
    void loadOneOneTest() throws NoSuchFieldException {


        Student student = studentMapper.selectById(1);

        (new LoadService()).load(student,"studentClass");
        System.out.println(student);


    }




}
