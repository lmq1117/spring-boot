package com.sam.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {
    //rabbitmq的通讯端口
    public static final int PORT = 5672;

    //rabbitmq的服务IP
    public static final String HOST = "47.52.22.55";

    //rabbitmq的虚拟机
    public static final String VIRTUAL_HOST = "/";

    //rabbitmq的用户名密码
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin";

    public static void main(String[] args) throws Exception {
        // step 1 创建一个ConnectionFactory并配置
        ConnectionFactory cf = new ConnectionFactory();
        cf.setUsername(USERNAME);
        cf.setPassword(PASSWORD);
        cf.setVirtualHost(VIRTUAL_HOST);
        cf.setHost(HOST);
        cf.setPort(PORT);

        //step2 通过ConnectionFactory创建一个链接
        Connection connection = cf.newConnection();

        //step 3 通过connection创建一个方 channel
        Channel channel = connection.createChannel();

        // 接收消息的队列
        String queueName = "print-queue";
        //channel.excha

        // 参数1 队列名
        // 参数2 是否持久化 true 队列会存盘 在服务重启的时候保证不丢失相关信息
        // 参数3 是否自动删除队列 最后一个消费者断开连接后是否自动删除
        // 参数4
        // 参数5 其他参数 如
        channel.queueDeclare(queueName,true,false,false,null);

        //创建消费者
        DefaultConsumer consumer = new MyConsumer(channel);

        //设置channel
        channel.basicConsume(queueName,true,consumer);

        //while (true){
        //    consumer.
        //}
    }



}
