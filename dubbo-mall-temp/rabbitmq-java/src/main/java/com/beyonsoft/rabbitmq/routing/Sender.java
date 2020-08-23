package com.beyonsoft.rabbitmq.routing;

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

    //简单交换机
    private final static String EXCHANGE_NAME="direct_exchange";

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
        //4、声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        //5、发布消息
        /*for (int i = 1; i <= 10; i++) {
            String msg="第"+i+"次打卡";
            channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());
        }*/
        channel.basicPublish(EXCHANGE_NAME,"nba",null,"克莱宣布加盟湖人队！".getBytes());
        channel.basicPublish(EXCHANGE_NAME,"cba",null,"周琦宣布加盟湖公洞宏远！".getBytes());
        System.out.println("消息发送完毕");
    }
}
