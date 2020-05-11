package com.progor.study.controller;

import com.progor.study.entity.User;
import com.progor.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/user/list")
    public List<User> listUser() {
        List<User> users = userService.listUser();
        return users;
    }

}
