package com.itheima.mp.service.impl;

import com.itheima.mp.domain.po.Order;
import com.itheima.mp.domain.vo.OrderVo;
import com.itheima.mp.mapper.OrderMapper;
import com.itheima.mp.mapper.ScheduleMapper;
import com.itheima.mp.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.hpsf.Decimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Service
public class OrderServiceImpl  implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<OrderVo> list() {

          List<OrderVo> list =orderMapper.getAllOrders();
          return list;
    }

    @Override
    public void removeById(Integer orderId) {
        orderMapper.deleteById(orderId);
    }

    /**
     * 根据用户id查询订单
     * @param userId
     * @return
     */
    @Override
    public List<Order> getByUserId(Integer userId) {
        List<Order> list = orderMapper.getByUserId(userId);
        return list;
    }

    @Override
    public void userBuyTicket(Integer userId, Integer scheduleId) {
        orderMapper.userBuyTicket(userId,scheduleId);
    }

    @Override
    public Order getById(Integer OrderId) {
        return orderMapper.selectById(OrderId);
    }

    //根据订单ID查询订单价格
    @Override
    public BigDecimal getTicketsPrice(Integer orderId) {
        //先根据订单ID查询车次ID
        Integer scheduleId = orderMapper.getScheduleIdByOrderId(orderId);
        //再根据车次ID查询车次价格
        BigDecimal ticketPrice = scheduleMapper.getTicketPriceByScheduleId(scheduleId);

        return ticketPrice;
    }

    //创建订单，但不扣除余票，等待支付回调
    @Override
    public Order createOrder(Integer userId, Integer scheduleId) {
        Order order = new Order();
        order.setUserId(userId);
        order.setScheduleId(scheduleId);

        // 插入订单，并自动回填自增主键到 order 对象的 id 字段
        orderMapper.insert(order);


        // 你可以在此返回带有自增主键的 order 对象
        return order;
    }


    @Override
    public Order getOrderByTradeNo(String outTradeNo) {
        return orderMapper.getOrderByTradeNo(outTradeNo);
    }

}
