package com.beyondsoft.springbootjavamail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@SpringBootTest
class SpringbootJavaMailApplicationTests {

    @Autowired
    private MailSender mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("q498601485@163.com");
        message.setTo("498601485@qq.com");
        message.setSubject("您有一个新消息");
        message.setText("Hello 你好 我是 超越，好久不见！甚是想念 东风吹战鼓擂 共产党怕过谁");
        mailSender.send(message);
    }

}
