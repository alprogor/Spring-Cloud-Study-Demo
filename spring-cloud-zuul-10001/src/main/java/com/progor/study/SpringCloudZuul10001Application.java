package com.progor.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient // 需要加eureka，因为他也需要拉取服务列表
public class SpringCloudZuul10001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuul10001Application.class, args);
    }

}
