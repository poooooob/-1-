package com.itheima.mp.controller;


import com.itheima.mp.domain.po.Station;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 车站表 前端控制器
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@RestController
@Slf4j
@RequestMapping("/station")
public class StationController {


    //展示所有车站信息
    @Autowired
    private StationService stationService;
    @GetMapping("/getAllStations")
    public Result getStation(){
        List<Station> stationList = stationService.list();
        log.info("查询所有车站信息:{}",stationList);
        return Result.success(stationList);
    }

    //增加车站
    @PostMapping("/addStation")
    public Result addStation(@RequestBody Station station){
        log.info("增加车站信息:{}",station);
        stationService.add(station);
        return Result.success();
    }
    //根据车站ID删除车站
    @DeleteMapping("/deleteStation/{id}")
    public Result deleteStation(@PathVariable Integer id){
        log.info("根据ID删除车站:{}",id);
        stationService.delete(id);
        return Result.success();
    }

}
