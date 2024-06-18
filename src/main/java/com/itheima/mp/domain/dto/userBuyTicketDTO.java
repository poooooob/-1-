package com.itheima.mp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userBuyTicketDTO {

    private Integer scheduleId;
    private Integer vehicleId;
    private String routeName;
    private String departureStation;
    private String arrivalStation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private BigDecimal ticketPrice;
    private Integer availableSeats;
}
