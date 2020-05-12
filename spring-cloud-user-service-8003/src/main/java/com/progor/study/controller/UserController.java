package com.progor.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.progor.study.entity.User;
import com.progor.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// 由于返回json数据，懒得加注解@ResponseBody了，加个RestController
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new RuntimeException("该ID：" + id + "没有对应的用户信息");
        }
        return user;
    }

    private static int count = 0;
    @GetMapping("/user/list")
    // fallbackMethod时发生错误时调用的方法，
    // commandProperties用于配置熔断器，requestVolumeThreshold代表请求多少次就不再尝试调用原方法，直接调用错误处理方法。
    @HystrixCommand(fallbackMethod = "listUserByHystirx", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), //请求次数
    }) //
    public List<User> listUser() throws InterruptedException {
        count = count + 1;  // 假装偶尔发生了bug
        System.out.println(count);
        // 偶尔发生时
        if (count % 2 == 0) {
            Thread.sleep(5000);
        }
        // 一直发生时：
//        Thread.sleep(5000);


        List<User> users = userService.listUser();
        return users;
    }

    public List<User> listUserByHystirx() {
        User user = new User(0, "null", "null");
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

}
