package com.progor.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 启用Eureka Client
public class UserService8001Application {
    public static void main(String[] args) {
        SpringApplication.run(UserService8001Application.class, args);
    }
}
