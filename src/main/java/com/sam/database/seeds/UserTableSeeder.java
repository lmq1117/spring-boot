package com.sam.database.seeds;

import com.sam.entity.User;
import java.util.Arrays;
import java.util.List;

public class UserTableSeeder {

public static List<User> data = Arrays.asList(
        new User(1,"刘备",60,null,null),
        new User(2,"关羽",58,null,null),
        new User(3,"张飞",55,null,null),
        new User(16,"小猫狗2",23,null,null),
        new User(17,"小花",26,null,null)
    );


}