package com.progor.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {

    @GetMapping("/msg/list")
    public Map<String, String> list() {
        Map<String, String> map = new HashMap<>();
        map.put("msg", "run in 8004");
        return map;
    }
}
