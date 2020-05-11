package com.progor.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudMessageService8005Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMessageService8005Application.class, args);
    }

}
