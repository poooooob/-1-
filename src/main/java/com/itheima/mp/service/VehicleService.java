package com.itheima.mp.service;

import com.itheima.mp.domain.po.Vehicle;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 车辆表 服务类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
public interface VehicleService {

    List<Vehicle> list();

    void add(Vehicle vehicle);

    void delete(Integer id);
}
