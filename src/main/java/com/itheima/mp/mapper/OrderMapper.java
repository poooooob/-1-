package com.itheima.mp.mapper;

import com.itheima.mp.domain.po.Order;
import com.itheima.mp.domain.vo.OrderVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    //根据用户id查询历史订单
    @Select("SELECT * FROM carmanage.orders WHERE user_id = #{userId}")
    List<Order> getByUserId(Integer userId);


    //用户购买车票
    @Insert("INSERT INTO carmanage.orders (user_id, schedule_id, order_time)" +
            " VALUES (#{userId}, #{scheduleId}, NOW())")
    void userBuyTicket(Integer userId, Integer scheduleId);

    //根据订单ID查询订单信息
    @Select("SELECT * FROM carmanage.orders WHERE order_id = #{orderId}")
    Order selectById(Integer orderId);


    //创建订单但不扣除余票
    void insert(Order order);

    @Select("SELECT * FROM carmanage.orders WHERE order_id = #{outTradeNo}")
    Order getOrderByTradeNo(String outTradeNo);

    //根据OrderId获取ScheduleId
    @Select("SELECT schedule_id FROM carmanage.orders WHERE order_id = #{orderId}")
    Integer getScheduleIdByOrderId(Integer orderId);
}
