package com.example.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Demo01Application {


    /**
     * @Description: 手动注入RestTemplate
     *
     * <p>启动报错：找不到RestTemplate
     *
     * @auther: zpq
     * @date: 2020/11/5 4:13 下午
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(Demo01Application.class, args);
    }

}
