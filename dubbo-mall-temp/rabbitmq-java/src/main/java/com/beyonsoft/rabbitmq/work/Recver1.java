package com.beyonsoft.rabbitmq.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recver1 {

    private final static String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1、连接MQ服务器
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/admin");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost("192.168.0.108");
        factory.setPort(5672);
        //2、发送消息给MQ服务器
        Connection connection = factory.newConnection();
        //3、基于channel 类似会话的作用
        Channel channel = connection.createChannel();
        //4、声明消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //处理接收到的消息
                String msg = new String(body,"utf-8");
                System.out.println("Recv1==> 接收到的消息为："+msg);
            }
        };
        //5、让消费者监听队列
        //autoAck 自动回复 true 另外还有手工模式
        channel.basicConsume(QUEUE_NAME,true,consumer);

    }
}