package com.progor.study.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 注意，要使用@Component
@Component
public class MessageServiceHystrix implements MessageService {
    @Override
    public Map<String, String> list() {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "服务端已停止服务");
        return map;
    }
}
