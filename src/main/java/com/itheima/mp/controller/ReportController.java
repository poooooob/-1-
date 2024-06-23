package com.itheima.mp.controller;

import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.domain.vo.RevenueVo;
import com.itheima.mp.domain.vo.RouteCountVo;
import com.itheima.mp.domain.vo.UserDistributionVo;
import com.itheima.mp.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;

    //用户分布统计
    @GetMapping("/user-distribution")
    public Result getUserDistribution() {

        List<UserDistributionVo> userDistribution = reportService.getUserDistribution();
        return Result.success(userDistribution);
    }

    //营业额统计
    @GetMapping("/revenue")
    public Result getMonthlyRevenue() {
        List<RevenueVo> revenueList = reportService.getMonthlyRevenue();
        return Result.success(revenueList);
    }

    //路线统计
    @GetMapping("/route-count")
    public Result getRouteCounts() {
        List<RouteCountVo> routeCounts = reportService.getRouteCounts();
        return Result.success(routeCounts);
    }

}
