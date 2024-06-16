package com.itheima.mp.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class queryVo {
    //订单号，用户姓名，车次id，发车时间，路线号，车辆号，出发站，到达站，票价
    private Integer orderId;
    private String  userName;
    private Integer routeId;
    private Integer scheduleId;
    private Integer vehicleId;
    private LocalDateTime departureTime;
    private String departureStation;
    private String arrivalStation;
    private Double ticketPrice;

}
