package com.sam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sam.pojo.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList();


    @Insert("insert into user (id,name,age,email) values(#{id},#{name},#{age},#{email})")
    int insertUser(User user);
}
