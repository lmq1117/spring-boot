package com.sam;

import com.sam.dao.MemberMapper;
import com.sam.dao.UserMapper;
import com.sam.entity.Member;
import com.sam.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)//可以在spring环境下运行juint测试
@SpringBootTest
class InsertTest {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void contextLoads() {


        User user = new User();
        user.setName("刘明强");
        user.setAge(31);
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        int affectRowsNum = userMapper.insert(user);
        System.out.println("影响记录数：" + affectRowsNum);
    }

    @Test
    public void insertMember(){
        Member member = new Member();
        //member.setId(1L);
        member.setName("王小二");
        member.setAge(20);
        member.setCreateTime(LocalDateTime.now());
        member.setEmail("wangxiaoer@qq.com");
        member.setUserId(1L);
        member.setManagerId(0L);
        int affectRowsNum = memberMapper.insert(member);
        System.out.println("影响记录数：" + affectRowsNum);

    }

}
