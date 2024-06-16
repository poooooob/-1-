package com.itheima.mp.service.impl;

import com.itheima.mp.domain.dto.RouteDTO;
import com.itheima.mp.domain.po.Route;
import com.itheima.mp.domain.vo.RouteVo;
import com.itheima.mp.mapper.RouteMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 线路表 服务实现类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Service
public class RouteServiceImpl  implements RouteService {

    @Autowired
    private RouteMapper routeMapper;

    //展示所有线路
    @Override
    public List<RouteVo> getAllRoutes() {
        return routeMapper.getAllRoutes();
    }

    @Override
    public void save(RouteDTO routeDTO) {
        //将RouteDTO转换为Route实体并保存到数据库
        Route route = new Route();
        route.setRouteName(routeDTO.getRouteName());
        route.setRouteStart(routeDTO.getStartStation());
        route.setRouteEnd(routeDTO.getEndStation());

        routeMapper.insert(route);
    }

    @Override
    public void removeById(Integer routeId) {
        routeMapper.deleteById(routeId);
    }


}
