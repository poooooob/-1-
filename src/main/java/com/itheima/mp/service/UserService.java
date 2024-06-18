package com.itheima.mp.service;

import com.itheima.mp.domain.dto.loginDTO;
import com.itheima.mp.domain.po.User;

import java.util.List;

public interface UserService {
    List<User> list();

    void removeById(Integer id);

    void saveAll(List<User> userList);

    User login(loginDTO loginDTO);

    User findUserById(Integer userId);

    void updateUser(User user);
}
