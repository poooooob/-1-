package com.itheima.mp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class updateUserDTO {

    private String userPhone;

    private String userAccount;

    private String userLocation;
}
