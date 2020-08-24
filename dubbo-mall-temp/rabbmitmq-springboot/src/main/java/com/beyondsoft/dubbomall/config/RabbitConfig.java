package com.beyondsoft.dubbomall.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue getQueue(){
        return new Queue("springboot-simple-queue",true,false,false);
    }
}
