package com.itheima.mp.controller;


import com.itheima.mp.domain.po.Schedule;
import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.domain.vo.ScheduleVo;
import com.itheima.mp.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 车次表 前端控制器
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Slf4j
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    //展示所有车次
    @GetMapping("/getAllSchedules")
    public Result getAllSchedules(){
      log.info("展示所有车次:{}," );
      List<ScheduleVo> list = scheduleService.getAllSchedules();
        return Result.success(list);
    }
    //增加车次
    @PostMapping("/addSchedule")
    public Result addSchedule(@RequestBody Schedule schedule){
        log.info("增加车次:{}," );
        scheduleService.add(schedule);
        return Result.success();
    }

    //根据ID查询车次
    @GetMapping("/getScheduleById/{scheduleId}")
    public Result getScheduleById(@PathVariable Integer scheduleId){
        log.info("根据ID查询车次:{}," );
        ScheduleVo schedulevo = scheduleService.getById(scheduleId);
        return Result.success(schedulevo);
    }
    //根据ID修改车次
    @PutMapping("/updateSchedule/{scheduleId}")
    public Result updateSchedule(@PathVariable Integer scheduleId,@RequestBody Schedule schedule){
        log.info("根据ID修改车次:{}," );
        scheduleService.update(scheduleId,schedule);
        return Result.success();
    }

    //删除车次
    @DeleteMapping("/deleteSchedule/{scheduleId}")
    public Result deleteSchedule(@PathVariable Integer scheduleId){
        log.info("删除车次:{}," );
        scheduleService.delete(scheduleId);
        return Result.success();
    }
}
