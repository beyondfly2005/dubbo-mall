package com.beyondsoft.dubbomall.simple;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleRecver {

    @RabbitListener(queues = "springboot-simple-queue")
    public  void process(String msg){
        System.out.println("接收到的消息为"+msg);
    }

}
