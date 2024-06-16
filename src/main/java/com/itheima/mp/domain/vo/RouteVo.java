package com.itheima.mp.domain.vo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("RouteVo")
public class RouteVo {

    private Integer routeId;
    private String routeName;
    private String startStation;
    private String endStation;
}
