package com.sam.database.seeds;

import com.sam.entity.User;
import java.util.Arrays;
import java.util.List;

public class UserTableSeeder {

    public static List<User> data = Arrays.asList(
            new User(1, "刘备", 58, null, null),
            new User(2, "张飞", 58, null, null)
    );
}
