package com.itheima.mp.mapper;

import com.itheima.mp.domain.po.Route;

import com.itheima.mp.domain.vo.RouteVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 线路表 Mapper 接口
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Mapper
public interface RouteMapper  {


    @Select("SELECT r.route_id AS routeId, " +
            "r.route_name AS routeName, " +
            "s1.station_name AS startStation, " +
            "s2.station_name AS endStation " +
            "FROM carmanage.route r " +
            "JOIN carmanage.station s1 ON r.start_station_id = s1.station_id " +
            "JOIN carmanage.station s2 ON r.end_station_id = s2.station_id")
    List<RouteVo> getAllRoutes();


    @Insert("INSERT INTO carmanage.route(route_name,start_station_id,end_station_id) VALUES(#{routeName},#{routeStart},#{routeEnd})")
    void insert(Route route);

    @Delete("DELETE FROM carmanage.route WHERE route_id = #{routeId}")
    void deleteById(Integer routeId);
}
