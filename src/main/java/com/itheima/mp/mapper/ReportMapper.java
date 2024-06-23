package com.itheima.mp.mapper;

import com.itheima.mp.domain.vo.RevenueVo;
import com.itheima.mp.domain.vo.RouteCountVo;
import com.itheima.mp.domain.vo.UserDistributionVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReportMapper {
    @Select("SELECT user_location userLocation, COUNT(*) value FROM user GROUP BY user_location")
    List<UserDistributionVo> getUserDistribution();

    @Select("SELECT DATE_FORMAT(o.order_time, '%Y-%m') AS date, SUM(s.ticket_price) AS revenue " +
            "FROM carmanage.orders o " +
            "JOIN carmanage.schedule s ON o.schedule_id = s.schedule_id " +
            "GROUP BY DATE_FORMAT(o.order_time, '%Y-%m')")
    List<RevenueVo> getMonthlyRevenue();

    @Select("SELECT r.route_name AS routeName, COUNT(o.schedule_id) AS count " +
            "FROM carmanage.orders o " +
            "JOIN carmanage.schedule s ON o.schedule_id = s.schedule_id " +
            "JOIN carmanage.route r ON s.route_id = r.route_id " +
            "GROUP BY r.route_id")
    List<RouteCountVo> getRouteCounts();
}
