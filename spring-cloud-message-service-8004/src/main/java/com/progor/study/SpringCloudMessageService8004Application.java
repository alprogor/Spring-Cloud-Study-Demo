package com.progor.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudMessageService8004Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMessageService8004Application.class, args);
    }
}
