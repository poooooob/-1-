package com.itheima.mp.service.impl;

import com.itheima.mp.domain.po.Station;
import com.itheima.mp.mapper.StationMapper;
import com.itheima.mp.service.StationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 车站表 服务实现类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Service
public class StationServiceImpl  implements StationService {

    @Autowired
    private StationMapper stationMapper;


    //增加车站
    @Override
    public void add(Station station) {

        //调用mapper层的方法
        stationMapper.add(station);

    }

    @Override
    public void delete(Integer id) {
        //调用mapper层的方法
        stationMapper.deleteById(id);
    }

    @Override
    public List<Station> list() {
     List<Station> list =  stationMapper.list();
        return list;
    }
}
