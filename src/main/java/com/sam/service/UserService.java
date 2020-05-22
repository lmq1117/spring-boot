package com.sam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sam.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    boolean saveUserService(User user);
    List<User> getAllUser();
    boolean updateUser(User user);
    User getUserById(Integer id);
}
