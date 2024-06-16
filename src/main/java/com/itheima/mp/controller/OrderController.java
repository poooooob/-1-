package com.itheima.mp.controller;


import com.itheima.mp.domain.vo.OrderVo;
import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.PhantomReference;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //查询所有订单信息，返回OrderVo集合
    @GetMapping("/getAllOrders")
    public Result getAllOrders(){
        List<OrderVo> list = orderService.list();

        return Result.success(list);
    }

    //根据订单ID删除订单
    @DeleteMapping("/deleteOrderById/{orderId}")
    public Result deleteOrderById(@PathVariable Integer orderId){
        log.info("删除订单，订单ID：{}",orderId);
        orderService.removeById(orderId);
        return Result.success();
    }

}
