package com.beyondsoft.freemarker;

import com.beyondsoft.freemarker.entity.Product;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FreemarkerApplicationTests {

    private Configuration configuration;

    @Test
    void createHtml() throws IOException ,TemplateException {
        System.out.println("AA");
        //模板+数据=输出
        //1. 获取模板对象
        Template template = configuration.getTemplate("freemarker.ftl");
        //2.数据
        Map<String,Object> data = new HashMap<>();
        data.put("name","Java2020");

        //对象
        Product product = new Product();
        product.setId(1);
        product.setName("格力电风扇");
        product.setProduction_date(new Date());
        data.put("product",product);

        //3.输出
        FileWriter writer = new FileWriter("D:\\workspace\\dubbo-mall\\dubbo-mall-temp\\freemarker\\src\\main\\resources\\templates");
        template.process(data,writer);
        System.out.println("生成静态页面成功");

    }

}
