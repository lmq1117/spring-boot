package com.sam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sam.pojo.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList();
}
