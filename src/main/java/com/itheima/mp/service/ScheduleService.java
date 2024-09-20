package com.itheima.mp.service;

import com.itheima.mp.domain.dto.userBuyTicketDTO;
import com.itheima.mp.domain.po.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.vo.ScheduleVo;

import java.util.List;

/**
 * <p>
 * 车次表 服务类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
public interface ScheduleService {


    List<ScheduleVo> getAllSchedules();


    void add(Schedule schedule);

    void delete(Integer scheduleId);


    ScheduleVo getById(Integer scheduleId);

    void update(Integer scheduleId, Schedule schedule);

    //用户端展示所有车次
    List<userBuyTicketDTO> showTicket();


    //用户购票后余票减1
    void deleteAvailableSeats(Integer scheduleId);

    //判断是否有余票
    boolean hasAvailableSeats(Integer scheduleId);
}
