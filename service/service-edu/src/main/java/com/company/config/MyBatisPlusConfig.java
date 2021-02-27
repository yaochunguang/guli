package com.company.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @author: chunguang.yao
 * @date: 2021-02-27 22:06
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.company.eduservice.mapper")
public class MyBatisPlusConfig {
}
