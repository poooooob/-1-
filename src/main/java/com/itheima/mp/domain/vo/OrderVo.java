package com.itheima.mp.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {
    private Integer orderId;
    private Integer userId;

    private String userName;
    private Integer scheduleId;
    private BigDecimal ticketPrice;
    private LocalDateTime orderTime;
}
