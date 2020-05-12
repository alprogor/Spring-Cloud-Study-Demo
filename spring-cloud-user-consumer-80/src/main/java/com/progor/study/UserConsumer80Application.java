package com.progor.study;

import com.progor.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "USERSERIVE", configuration = MyConfig.class)
@EnableFeignClients // 使用feign
public class UserConsumer80Application {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumer80Application.class, args);
    }
}
