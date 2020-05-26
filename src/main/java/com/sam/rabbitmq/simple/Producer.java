package com.sam.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
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

        //step4 通过channel 发送数据
        for (int i = 0; i < 10000000; i++) {
            String msg = "Hello RabbitMQ!" + i;

            // 1 交换机名
            // 2 路由key或者 队列
            // 3 附属参数
            // 4 消息内容
            // 没有交换机的发送，参数2不是路由key 而是队列名
            channel.basicPublish("", "print-queue", null, msg.getBytes());
        }

        //关闭相关链接
        channel.close();
        connection.close();

    }

}
