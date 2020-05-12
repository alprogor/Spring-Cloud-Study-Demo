package com.progor.study.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

// 由于这种服务的服务消费者可能比较多，放到共有依赖中。
// 使用fallback指定一个类，这个类实现了MessageService，发生服务不可用的时候就会调用这个类中方法
@FeignClient(value = "MESSAGESERIVE", fallback = MessageServiceHystrix.class)
public interface MessageService {
    // 这里使用RequestMapping将服务提供者的方法与本地Service方法建立映射
    @RequestMapping(value = "/msg/list", method = RequestMethod.GET)
    Map<String, String> list();
}