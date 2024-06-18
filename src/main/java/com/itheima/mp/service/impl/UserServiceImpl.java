package com.itheima.mp.service.impl;

import com.itheima.mp.domain.dto.loginDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {

        return userMapper.list();
    }

    @Override
    public void removeById(Integer id) {

        userMapper.removeById(id);
    }

    @Override
    public void saveAll(List<User> userList) {
        userMapper.saveAll(userList);
    }

    @Override
    public User login(loginDTO loginDTO) {
        return userMapper.login(loginDTO);
    }

    @Override
    public User findUserById(Integer userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}
