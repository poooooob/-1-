package com.itheima.mp.service;

import com.itheima.mp.domain.po.Order;
import com.itheima.mp.domain.vo.OrderVo;
import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
public interface OrderService  {

    List<OrderVo> list();

    void removeById(Integer orderId);

    List<Order> getByUserId(Integer userId);

    void userBuyTicket(Integer userId, Integer scheduleId);

    //根据订单ID查询订单信息
    Order getById(Integer OrderId);

    //根据订单ID查询订单价格
    BigDecimal getTicketsPrice(Integer orderId);

    //创建订单
    Order createOrder(Integer userId, Integer scheduleId);

    //根据商户订单号查询订单
    Order getOrderByTradeNo(String outTradeNo);
}
