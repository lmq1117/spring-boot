package com.sam;

import com.sam.dao.UserMapper;
import com.sam.database.seeds.DbSeed;
import org.apache.velocity.app.VelocityEngine;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class DbSeedTests {
    @Autowired
    DbSeed dbSeed;


    @Autowired
    UserMapper userMapper;

    //@Test
    //void iSeed(){
    //    new VelocityEngine();
    //}


    @Test
    void up(){
        dbSeed.up();
    }


    @Test
    void down(){
        dbSeed.down();
    }

    @Test
    void truncate(){
        userMapper.truncate();
    }
}
