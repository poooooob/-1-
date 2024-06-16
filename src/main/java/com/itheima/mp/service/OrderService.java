package com.itheima.mp.service;

import com.itheima.mp.domain.vo.OrderVo;

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
}
