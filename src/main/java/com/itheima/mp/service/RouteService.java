package com.itheima.mp.service;


import com.itheima.mp.domain.dto.RouteDTO;
import com.itheima.mp.domain.po.Route;
import com.itheima.mp.domain.vo.RouteVo;

import java.util.List;

public interface RouteService {


    List<RouteVo> getAllRoutes();


    void save(RouteDTO routeDTO);

    void removeById(Integer routeId);
}
