package com.sam.job.mq;

import cn.hutool.core.lang.Console;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloConsumer {
    @RabbitHandler
    public void handler(String message){
        Console.log("消费者消费消息");
        Console.log(message);
    }
}
