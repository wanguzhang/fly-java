package com.fly.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author 张攀钦
 * @date 2019/6/10-18:06
 * 项目启动
 */
@SpringBootApplication(exclude =DataSourceAutoConfiguration.class )
public class FlyJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyJavaApplication.class, args);
    }

}
