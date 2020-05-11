package com.progor.study.dao;

import com.progor.study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> listUser();

    User getUser(Integer id);
}
