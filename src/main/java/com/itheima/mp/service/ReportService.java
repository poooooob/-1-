package com.itheima.mp.service;

import com.itheima.mp.domain.vo.RevenueVo;
import com.itheima.mp.domain.vo.RouteCountVo;
import com.itheima.mp.domain.vo.UserDistributionVo;

import java.util.List;

public interface ReportService {


    List<UserDistributionVo> getUserDistribution();

    List<RevenueVo> getMonthlyRevenue();

    List<RouteCountVo> getRouteCounts();
}
