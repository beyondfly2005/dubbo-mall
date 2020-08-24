package com.beyondsoft.dubbomall;

import com.beyondsoft.dubbomall.simple.SimpleSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DubboMallApplicationTests {

    @Autowired
    private SimpleSender simpleSender;

    @Test
    void contextLoads() {
        simpleSender.send("SpringBoot整合RabbmitMQ成功！");
    }

}
