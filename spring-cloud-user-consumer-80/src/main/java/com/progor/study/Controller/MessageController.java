package com.progor.study.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class MessageController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://MESSAGESERIVE";


    @GetMapping("/msg/list")
    public Map<String, String> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/msg/list", Map.class);
    }

}
