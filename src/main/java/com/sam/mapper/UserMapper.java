package com.sam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sam.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList();


    @Insert("insert into user (id,name,age,email) values(#{id},#{name},#{age},#{email})")
    public int insertUser(User user);

    @Select("select id,name,age,email,created_at as createdAt from user")
    public List<User> getAllUser();

    @Update("update users set name=#{name},age=#{age},email=#{email} where id = #{id}")
    public int updateUser(User user);

    @Select("select id,name,age,email,created_at createdAt from user where id = #{id}")
    public User getUserById(Integer id);
}
