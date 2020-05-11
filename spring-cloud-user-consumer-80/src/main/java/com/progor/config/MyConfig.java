package com.progor.config;

import com.netflix.loadbalancer.IRule;
import com.progor.study.myrule.MyLoadBalancedRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public IRule myRule() {
        return new MyLoadBalancedRule();// 使用我们自定义的规则
    }
}
