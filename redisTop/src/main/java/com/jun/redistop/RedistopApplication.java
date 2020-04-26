package com.jun.redistop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class RedistopApplication {

    public static void main(String[] args) {
        //启动引导类
        SpringApplication.run(RedistopApplication.class, args);
    }

}
