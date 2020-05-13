package com.progor.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServer11000Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServer11000Application.class, args);
    }
}
