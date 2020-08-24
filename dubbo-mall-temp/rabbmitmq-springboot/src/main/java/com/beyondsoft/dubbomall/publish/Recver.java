package com.beyondsoft.dubbomall.publish;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Recver {

    @RabbitListener(queues = "springboot-fanout-queue-1")
    public  void process1(String msg){
        System.out.println("监听队列1，接收到的消息为"+msg);
    }

    @RabbitListener(queues = "springboot-fanout-queue-2")
    public  void process2(String msg){
        System.out.println("监听队列2，接收到的消息为"+msg);
    }

}
