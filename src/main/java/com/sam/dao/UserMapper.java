package com.sam.dao;

import com.sam.entity.User;
import com.sam.utils.mpp.MyBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper extends MyBaseMapper<User> {



}
