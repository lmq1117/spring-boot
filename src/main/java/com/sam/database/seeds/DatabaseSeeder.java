package com.sam.database.seeds;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sam.dao.UserMapper;
import com.sam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder {
    private UserMapper userMapper;

    @Autowired
    public DatabaseSeeder(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        deleteUserTable();
        //seedUserTable();
    }


    private void seedUserTable(){
        System.out.println("###seedUserTable被执行了###");
        List<User> data = Arrays.asList(
                new User(1,"刘备", 58),
                new User(2,"关羽", 55),
                new User(3,"张飞", 51),
                new User(4,"赵云", 38),
                new User(5,"黄忠", 70),
                new User(6,"马超", 32),
                new User(7,"孔明", 50),
                new User(8,"糜夫人", 57),
                new User(9,"孙夫人", 32),
                new User(10,"阿斗", 22),
                new User(11,"曹操", 58),
                new User(12,"许褚", 58),
                new User(13,"荀彧", 58),
                new User(14,"张辽", 58),
                new User(15,"曹丕", 30)
        );

        data.forEach((user)->{
            if(0 == userMapper.selectList(new QueryWrapper<User>(user)).size()){
                userMapper.insert(user);
                System.out.println("插入了"+user.toString());
            }
        });

    }


    private void deleteUserTable(){
        List<User> data = Arrays.asList(
                new User(1,"刘备", 58),
                new User(2,"关羽", 55),
                new User(3,"张飞", 51),
                new User(4,"赵云", 38),
                new User(5,"黄忠", 70),
                new User(6,"马超", 32),
                new User(7,"孔明", 50),
                new User(8,"糜夫人", 57),
                new User(9,"孙夫人", 32),
                new User(10,"阿斗", 22),
                new User(11,"曹操", 58),
                new User(12,"许褚", 58),
                new User(13,"荀彧", 58),
                new User(14,"张辽", 58),
                new User(15,"曹丕", 30)
        );
        List<Integer> ids = new ArrayList<>();
        data.forEach((user)->{
            if(0 < userMapper.selectList(new QueryWrapper<User>(user)).size()){
                ids.add(user.getId());
                System.out.println("ids"+ids.toString());
            }
        });
        if(ids.size() > 0){
            userMapper.deleteBatchIds(ids);
            System.out.println(ids.toString());
        }


    }
}
