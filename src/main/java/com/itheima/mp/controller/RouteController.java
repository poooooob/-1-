package com.itheima.mp.controller;


import com.itheima.mp.domain.dto.RouteDTO;

import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.domain.vo.RouteVo;
import com.itheima.mp.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 线路表 前端控制器
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Slf4j
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;
    //展示所有线路
    @GetMapping("/getAllRoutes")
    public Result getAllRoutes(){

       List<RouteVo> list  = routeService.getAllRoutes();

        return Result.success(list);
    }

    //增加线路,前端传入RouteDTO
    @PostMapping("/addRoute")
    public Result addRoute(@RequestBody RouteDTO routeDTO){
        log.info("route:{}",routeDTO);
        routeService.save(routeDTO);
        return Result.success();
    }

    //删除线路,前端传入routeId
    @DeleteMapping("/deleteRoute/{routeId}")
    public Result deleteRoute(@PathVariable Integer routeId){
        routeService.removeById(routeId);
        return Result.success();
    }

}
