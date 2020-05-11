package com.progor.study.Controller;

import com.progor.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    // 注意这个restTemplate需要自己生成Bean,参考com.progor.study.config.AppConfig
    @Autowired
    private RestTemplate restTemplate;
    // 指定远程访问的URL，也就是服务提供者的URL
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    // 1.注释直接使用URL来调用服务的代码,
    // 2.下面使用eureka来调用,下面的"http://USERSERIVE"的USERSERIVE是服务的名字,Eureka页面中你看过的
    // 3.这样就从eureka中拉取到名为USERSERIVE的服务的列表,并从中选择一个服务实例调用
    private static final String REST_URL_PREFIX = "http://USERSERIVE";

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/" + id, User.class);
    }

    @GetMapping("/user/list")
    public List<User> listUser() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/list", List.class);
    }

}
