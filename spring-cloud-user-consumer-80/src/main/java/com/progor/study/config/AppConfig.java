package com.progor.study.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {
    @Bean
    @LoadBalanced // eureka与这个配合，要使用LoadBalanced才会调用eureka中注册的服务
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

