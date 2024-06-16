package com.itheima.mp.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ScheduleVo {
    //车次号，线路号，车辆号,路线名，起始站，到达站，出发时间，到达时间，车票价格，余票。
    private Integer scheduleId;
    private Integer vehicleId;
    private Integer routeId;

    private String routeName;

    private String startTime;
    private String endTime;
    private BigDecimal ticketPrice;
    private Integer availableTickets;
}
