package com.beyonsoft.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 默认轮流发送给消费者
 * 我们希望处理快的多处理一些，处理慢的少处理一些
 */
public class Sender {

    private final static String QUEUE_NAME="work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1、连接MQ服务器
        ConnectionFactory factory =new ConnectionFactory();
        factory.setVirtualHost("/admin");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost("192.168.0.108");
        factory.setPort(5672);

        //2、发送消息给MQ服务器
        Connection connection=factory.newConnection();
        //3、基于channel 类似会话的作用
        Channel channel = connection.createChannel();
        //4、声明队列，如果队列不存在则创建，否则不做处理
        //durable:持久化 异步设置为true
        //exclusive 排他性 是否只允许当前连接使用此队列 一般设置为false
        //autoDelete:自动删除 一般设置为false
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        //5、发布消息
        for (int i = 1; i <= 10; i++) {
            String msg="第"+i+"次打卡";
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        }
        System.out.println("消息发送完毕");
    }
}
