package com.itheima.mp.mapper;

import com.itheima.mp.domain.po.Schedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.mp.domain.vo.ScheduleVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 车次表 Mapper 接口
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Mapper
public interface ScheduleMapper  {

    @Select("SELECT " +
            "s.schedule_id AS scheduleId, " +
            "s.vehicle_id AS vehicleId, " +
            "s.route_id AS routeId, " +
            "r.route_name AS routeName, " +
            "s.departure_time AS startTime, " +
            "s.arrival_time AS endTime, " +
            "s.ticket_price AS ticketPrice, " +
            "s.available_seats AS availableTickets " +
            "FROM carmanage.schedule s " +
            "JOIN carmanage.route r ON s.route_id = r.route_id " +
            "JOIN carmanage.vehicle v ON s.vehicle_id = v.vehicle_id")
    List<ScheduleVo> getAllSchedules();

    @Insert("INSERT INTO carmanage.schedule (vehicle_id, route_id, departure_time, arrival_time, ticket_price, available_seats) " +
            "VALUES (#{vehicleId}, #{routeId}, #{departureTime}, #{arrivalTime}, #{ticketPrice}, #{availableSeats})")
    void insert(Schedule schedule);

    @Delete("DELETE FROM carmanage.schedule WHERE schedule_id = #{scheduleId}")
    void delete(Integer scheduleId);

    @Select("SELECT " +
            "s.schedule_id AS scheduleId, " +
            "s.vehicle_id AS vehicleId, " +
            "s.route_id AS routeId, " +
            "r.route_name AS routeName, " +
            "s.departure_time AS startTime, " +
            "s.arrival_time AS endTime, " +
            "s.ticket_price AS ticketPrice, " +
            "s.available_seats AS availableTickets " +
            "FROM carmanage.schedule s " +
            "JOIN carmanage.route r ON s.route_id = r.route_id " +
            "JOIN carmanage.vehicle v ON s.vehicle_id = v.vehicle_id " +
            "WHERE s.schedule_id = #{scheduleId}")
    ScheduleVo getById(Integer scheduleId);

    @Update("UPDATE carmanage.schedule " +
            "SET vehicle_id = #{schedule.vehicleId}, " +
            "route_id = #{schedule.routeId}, " +
            "departure_time = #{schedule.departureTime}, " +
            "arrival_time = #{schedule.arrivalTime}, " +
            "ticket_price = #{schedule.ticketPrice}, " +
            "available_seats = #{schedule.availableSeats} " +
            "WHERE schedule_id = #{scheduleId}")
    void update(Integer scheduleId, Schedule schedule);
}
