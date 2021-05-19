package com.sam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class RabbitMQTest {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test
    public void test() {
        rabbitTemplate.convertAndSend("hello", "hello world!");
    }


}
