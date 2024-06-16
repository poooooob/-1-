package com.itheima.mp.service;

import com.itheima.mp.domain.po.Station;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 车站表 服务类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
public interface StationService  {

    List<Station> list();

    void add(Station station);

    void delete(Integer id);


}
