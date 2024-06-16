package com.itheima.mp.service;

import com.itheima.mp.domain.po.User;

import java.util.List;

public interface UserService {
    List<User> list();

    void removeById(Integer id);
}
