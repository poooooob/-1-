package com.itheima.mp.service.impl;

import com.itheima.mp.domain.po.Vehicle;
import com.itheima.mp.mapper.VehicleMapper;
import com.itheima.mp.service.VehicleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 车辆表 服务实现类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Service
public class VehicleServiceImpl  implements VehicleService {

    @Autowired
    private VehicleMapper vehicleMapper;


    @Override
    public List<Vehicle> list() {
        //查询车辆
        return vehicleMapper.list();

    }

    @Override
    public void add(Vehicle vehicle) {
        //增加车辆
        vehicleMapper.add(vehicle);
    }

    @Override
    public void delete(Integer id) {
        //删除车辆
        vehicleMapper.delete(id);
    }
}
