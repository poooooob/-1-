package com.itheima.mp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class queryDTO {
    //客户姓名，车次id,目的地，发车时间，路线号，车辆号，出发站，到达站
    private String userName;
    private Integer routeId;
    private Integer scheduleId;
    private Integer vehicleId;
    private LocalDateTime departureTime;
    private String departureStation;
    private String arrivalStation;
}
