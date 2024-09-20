package com.itheima.mp.mapper;

import com.itheima.mp.domain.dto.userBuyTicketDTO;
import com.itheima.mp.domain.po.Schedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.mp.domain.vo.ScheduleVo;
import org.apache.ibatis.annotations.*;
import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;
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


    //用户端展示所有车次
    @Select("SELECT \n" +
            "    s.schedule_id AS scheduleId,\n" +
            "    s.vehicle_id AS vehicleId,\n" +
            "    r.route_name AS routeName,\n" +
            "    ss.station_name AS departureStation,\n" +
            "    es.station_name AS arrivalStation,\n" +
            "    s.departure_time AS departureTime,\n" +
            "    s.arrival_time AS arrivalTime,\n" +
            "    s.ticket_price AS ticketPrice,\n" +
            "    s.available_seats AS availableSeats\n" +
            "FROM \n" +
            "    carmanage.schedule s\n" +
            "JOIN \n" +
            "    carmanage.route r ON s.route_id = r.route_id\n" +
            "JOIN \n" +
            "    carmanage.station ss ON r.start_station_id = ss.station_id\n" +
            "JOIN \n" +
            "    carmanage.station es ON r.end_station_id = es.station_id;\n")
    List<userBuyTicketDTO> showTicket();

    //用户购票后余票减1
    @Update("UPDATE carmanage.schedule " +
            "SET available_seats = available_seats - 1 " +
            "WHERE schedule_id = #{scheduleId}")
    void deleteAvailableSeats(Integer scheduleId);

   

    //判断是否有余票
    @Select("SELECT available_seats FROM carmanage.schedule WHERE schedule_id = #{scheduleId}")
    Integer getAvailableSeats(Integer scheduleId);

    //根据车次ID查询车次价格
    @Select("SELECT ticket_price FROM carmanage.schedule WHERE schedule_id = #{scheduleId}")
    BigDecimal getTicketPriceByScheduleId(Integer scheduleId);
}
