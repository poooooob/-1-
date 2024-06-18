package com.itheima.mp.service.impl;

import com.itheima.mp.domain.po.Order;
import com.itheima.mp.domain.vo.OrderVo;
import com.itheima.mp.mapper.OrderMapper;
import com.itheima.mp.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
