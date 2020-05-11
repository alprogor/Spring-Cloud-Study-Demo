package com.progor.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class UserService8002ApplicationEurekaCluster {
    public static void main(String[] args) {
        SpringApplication.run(UserService8002ApplicationEurekaCluster.class, args);
    }
}
