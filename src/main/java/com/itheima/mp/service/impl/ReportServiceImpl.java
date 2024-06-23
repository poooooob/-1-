package com.itheima.mp.service.impl;

import com.itheima.mp.domain.vo.RevenueVo;
import com.itheima.mp.domain.vo.RouteCountVo;
import com.itheima.mp.domain.vo.UserDistributionVo;
import com.itheima.mp.mapper.ReportMapper;
import com.itheima.mp.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;


    @Override
    public List<UserDistributionVo> getUserDistribution() {
        return reportMapper.getUserDistribution();
    }

    @Override
    public List<RevenueVo> getMonthlyRevenue() {
        return reportMapper.getMonthlyRevenue();
    }

    @Override
    public List<RouteCountVo> getRouteCounts() {
        return reportMapper.getRouteCounts();
    }
}
