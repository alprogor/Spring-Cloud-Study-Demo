package com.progor.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserConsumer80Application {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumer80Application.class, args);
    }
}
