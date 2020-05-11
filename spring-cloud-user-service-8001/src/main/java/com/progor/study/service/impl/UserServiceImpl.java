package com.progor.study.service.impl;

import com.progor.study.dao.UserMapper;
import com.progor.study.entity.User;
import com.progor.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
}
