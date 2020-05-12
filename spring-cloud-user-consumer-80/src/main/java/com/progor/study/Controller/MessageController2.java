package com.progor.study.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.progor.study.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// 这个控制器用来处理使用fegin的情况
@RestController
public class MessageController2 {

    @Autowired
    private MessageService messageService;

    @GetMapping("/msg2/list")
    // 使用HystrixCommand
    @HystrixCommand(fallbackMethod = "listByHystirx", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), //请求次数
    }) //如果请求次数达到5次都是失败，那么直接调用listByHystirx
    public Map<String, String> list() {
        return messageService.list();
    }

    public Map<String, String> listByHystirx() {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "服务端已停止服务");
        return map;
    }
}
