package com.progor.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudHystrixDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixDashboard9001Application.class, args);
    }

}
