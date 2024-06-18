package com.itheima.mp.controller;

import com.itheima.mp.domain.dto.*;
import com.itheima.mp.domain.po.Order;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.service.OrderService;
import com.itheima.mp.service.ScheduleService;
import com.itheima.mp.service.UserService;
import com.itheima.mp.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private OrderService orderService;

    //登录接口
    @PostMapping
    public Result login(@RequestBody loginDTO loginDTO) {
        User user = userService.login(loginDTO);

        if (user != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", user.getUserId());
            map.put("userName", user.getUserName());

            String jwt = JwtUtils.generateJwt(map);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

    //查询当前登录用户的信息
    @GetMapping("/info")
    public Result getUserInfo(@RequestHeader("token") String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("taohongchen") // 替换为你的密钥
                    .parseClaimsJws(token)
                    .getBody();

            Integer userId = (Integer) claims.get("userId");
            if (userId == null) {
                return Result.error("无效的token");
            }

            User user = userService.findUserById(userId);
            return Result.success(user);
        } catch (Exception e) {
            return Result.error("token解析失败");
        }
    }

    //更新用户信息
    @PutMapping("/update")
    public Result updateUserInfo(@RequestBody updateUserDTO updateUserDTO, @RequestHeader("token") String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("taohongchen") // 替换为你的密钥
                    .parseClaimsJws(token)
                    .getBody();

            Integer userId = (Integer) claims.get("userId");
            if (userId == null) {
                return Result.error("无效的token");
            }

            User user = userService.findUserById(userId);
            if (user == null) {
                return Result.error("用户不存在");
            }

            user.setUserPhone(updateUserDTO.getUserPhone());
            user.setUserAccount(updateUserDTO.getUserAccount());
            user.setUserLocation(updateUserDTO.getUserLocation());

            userService.updateUser(user);

            return Result.success();
        } catch (Exception e) {
            return Result.error("更新用户信息失败");
        }
    }

    //实名认证
    @PutMapping("/verify")
    public Result realName(@RequestBody verifyUserDTO verifyUserDTO, @RequestHeader("token") String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("taohongchen") // 替换为你的密钥
                    .parseClaimsJws(token)
                    .getBody();

            Integer userId = (Integer) claims.get("userId");
            if (userId == null) {
                return Result.error("无效的token");
            }

            User user = userService.findUserById(userId);
            if (user == null) {
                return Result.error("用户不存在");
            }

            user.setUserIdCard(verifyUserDTO.getUserIdCard());
            user.setUserName(verifyUserDTO.getUserName());
            user.setUserIsVerified(true);

            userService.updateUser(user);

            return Result.success();
        } catch (Exception e) {
            return Result.error("实名认证失败");
        }
    }

    //更新实名信息
    @PutMapping("/updateVerify")
    public Result updateRealName(@RequestBody verifyUserDTO verifyUserDTO, @RequestHeader("token") String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("taohongchen") // 替换为你的密钥
                    .parseClaimsJws(token)
                    .getBody();

            Integer userId = (Integer) claims.get("userId");
            if (userId == null) {
                return Result.error("无效的token");
            }

            User user = userService.findUserById(userId);
            if (user == null) {
                return Result.error("用户不存在");
            }

            user.setUserIdCard(verifyUserDTO.getUserIdCard());
            user.setUserName(verifyUserDTO.getUserName());

            userService.updateUser(user);

            return Result.success();
        } catch (Exception e) {
            return Result.error("实名认证失败");
        }
    }

    //查询用户可购买的车次
    @GetMapping("/showTicket")
    public Result showTicket() {
        List<userBuyTicketDTO> tickets =scheduleService.showTicket();

        return Result.success(tickets);
    }

    //查询用户的历史订单
    @GetMapping("/showOrder")
    public Result showOrder(@RequestHeader("token") String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("taohongchen")
                    .parseClaimsJws(token)
                    .getBody();
            Integer userId = (Integer) claims.get("userId");
            if (userId == null) {
                return Result.error("无效的token");
            }

            List<Order>  list =  orderService.getByUserId(userId);

            return Result.success(list);

        } catch (Exception e) {
            return Result.error("token解析失败");
        }
    }
    // 用户购票
    @PostMapping("/purchaseTicket")
    public Result userBuyTicket(@RequestHeader("token") String token, @RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("taohongchen")
                    .parseClaimsJws(token)
                    .getBody();

            Integer userId = (Integer) claims.get("userId");
            if (userId == null) {
                return Result.error("无效的token");
            }

            Integer scheduleId = purchaseRequestDTO.getScheduleId();

            orderService.userBuyTicket(userId, scheduleId);

            return Result.success();

        } catch (Exception e) {
            return Result.error("token解析失败");
        }
    }


}



