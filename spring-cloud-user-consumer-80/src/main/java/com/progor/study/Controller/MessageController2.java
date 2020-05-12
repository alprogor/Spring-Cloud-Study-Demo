package com.progor.study.Controller;

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
    public Map<String, String> list() {
        return messageService.list();
    }

}
