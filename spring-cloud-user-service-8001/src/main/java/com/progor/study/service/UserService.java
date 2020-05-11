package com.progor.study.service;

import com.progor.study.entity.User;

import java.util.List;

public interface UserService {
    User getUser(Integer id);

    List<User> listUser();
}
