package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: yaochunguang
 * @date: 2021-02-27 16:05
 * @description: 启动类
 **/
@ComponentScan(basePackages = {"com.company"})
@SpringBootApplication
@EnableSwagger2
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
