package com.sam.database.seeds;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sam.dao.UserMapper;
import com.sam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserTableSeeder implements Runnable {

    //@Autowired
    private UserMapper userMapper;

    //public static void main(String[] args) {
    //    seedUserTable();
    //}


    private List<User> data = Arrays.asList(
            new User("刘备", 58),
            new User("关羽", 55),
            new User("张飞", 51),
            new User("赵云", 38),
            new User("黄忠", 70),
            new User("马超", 32),
            new User("孔明", 50),
            new User("糜夫人", 57),
            new User("孙夫人", 32),
            new User("阿斗", 22),
            new User("曹操", 58),
            new User("许褚", 58),
            new User("荀彧", 58),
            new User("张辽", 58),
            new User("曹丕", 30)
    );


    public UserTableSeeder(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public UserTableSeeder(){

    }


    public void seed() {
        seedUserTable();
    }



    private void seedUserTable(boolean undo) {
        ArrayList<Integer> ids = new ArrayList();
        for (User user : data) {
            QueryWrapper<User> wrapper = new QueryWrapper(user);
            ids.add(userMapper.selectOne(wrapper).getId());
        }
        userMapper.deleteBatchIds(ids);
    }

    private void seedUserTable() {
        for (User user : data) {
            userMapper.insert(user);
        }
    }

    @Override
    public void run() {
        for (User user : data) {
            userMapper.insert(user);
        }
    }
}
