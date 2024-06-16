package com.itheima.mp.controller;


import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    //前端发送请求，请求路径为user/getAllUser
    @GetMapping("/getAllUser")
    public Result getAllUser(){
        log.info("查询所有用户信息");
        List<User> userList = userService.list();
        return Result.success(userList);
    }

   //根据ID删除用户
    @DeleteMapping("/deleteUserById/{id}")
    public Result deleteUserById(@PathVariable("id") Integer id){
        log.info("根据ID删除用户信息:{}",id);
        userService.removeById(id);
        return Result.success();
    }

}
