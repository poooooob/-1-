package com.itheima.mp.controller;

import com.itheima.mp.domain.po.Vehicle;
import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 车辆表 前端控制器
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Slf4j
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    //显示所有车辆信息
    @GetMapping("/getAllVehicles")
    public Result getVehicle(){
        log.info("查询所有车辆信息:{}");
        List<Vehicle> vehicleList = vehicleService.list();
        return Result.success(vehicleList);
    }

    //添加车辆
    @PostMapping("/addVehicle")
    public Result addVehicle(@RequestBody Vehicle vehicle){
        log.info("增加车辆信息:{}",vehicle);
        vehicleService.add(vehicle);
        return Result.success();
    }

    //根据车辆ID删除车辆
    @DeleteMapping("/deleteVehicle/{id}")
    public Result deleteVehicle(@PathVariable Integer id){
        log.info("根据ID删除车辆:{}",id);
        vehicleService.delete(id);
        return Result.success();
    }
}
