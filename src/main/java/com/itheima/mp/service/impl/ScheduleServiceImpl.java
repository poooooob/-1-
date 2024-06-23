package com.itheima.mp.service.impl;

import com.itheima.mp.domain.dto.userBuyTicketDTO;
import com.itheima.mp.domain.po.Schedule;
import com.itheima.mp.domain.vo.ScheduleVo;
import com.itheima.mp.mapper.ScheduleMapper;
import com.itheima.mp.service.ScheduleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ref.PhantomReference;
import java.util.List;

/**
 * <p>
 * 车次表 服务实现类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Service
public class ScheduleServiceImpl  implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public List<ScheduleVo> getAllSchedules() {

        return scheduleMapper.getAllSchedules();
    }

    @Override
    public void add(Schedule schedule) {
        scheduleMapper.insert(schedule);
    }

    @Override
    public void delete(Integer scheduleId) {
        scheduleMapper.delete(scheduleId);
    }

    @Override
    public ScheduleVo getById(Integer scheduleId) {
        ScheduleVo scheduleVo = scheduleMapper.getById(scheduleId);
        return scheduleVo;
    }

    @Override
    public void update(Integer scheduleId, Schedule schedule) {
        scheduleMapper.update(scheduleId,schedule);
    }

    /**
     * 用户端展示所有车次
     * @return
     */
    @Override
    public List<userBuyTicketDTO> showTicket() {
        return scheduleMapper.showTicket();
    }


    /**
     * 用户购票后余票减1
     * @param scheduleId
     */
    @Override
    public void deleteAvailableSeats(Integer scheduleId) {
        scheduleMapper.deleteAvailableSeats(scheduleId);
    }


}
