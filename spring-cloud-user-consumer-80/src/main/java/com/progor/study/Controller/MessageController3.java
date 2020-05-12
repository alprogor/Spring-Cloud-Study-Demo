package com.progor.study.Controller;

import com.progor.study.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MessageController3 {

    @Autowired
    private MessageService messageService;

    @GetMapping("/msg3/list")
    public Map<String, String> list() {
        return messageService.list();
    }
}
