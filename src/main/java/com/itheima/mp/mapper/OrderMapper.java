package com.itheima.mp.mapper;

import com.itheima.mp.domain.vo.OrderVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Mapper
public interface OrderMapper  {

    @Select("SELECT " +
            "o.order_id AS orderId, " +
            "o.user_id AS userId, " +
            "o.schedule_id AS scheduleId, " +
            "u.user_name AS userName, " +
            "o.order_time AS orderTime, " +
            "s.ticket_price AS ticketPrice " +
            "FROM carmanage.orders o " +
            "JOIN carmanage.schedule s ON o.schedule_id = s.schedule_id " +
            "JOIN carmanage.user u ON o.user_id = u.user_id " +
            "JOIN carmanage.route r ON s.route_id = r.route_id")
    List<OrderVo> getAllOrders();

    @Delete("DELETE FROM carmanage.orders WHERE order_id = #{orderId}")
    void deleteById(Integer orderId);
}
