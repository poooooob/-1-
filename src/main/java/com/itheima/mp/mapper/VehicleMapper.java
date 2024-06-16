package com.itheima.mp.mapper;

import com.itheima.mp.domain.po.Vehicle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 车辆表 Mapper 接口
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Mapper
public interface VehicleMapper {

    @Select("select * from vehicle")
    List<Vehicle> list();

    @Insert("insert into vehicle(vehicle_type,vehicle_capacity) values(#{vehicleType},#{vehicleCapacity})")
    void add(Vehicle vehicle);

    @Delete("delete from vehicle where vehicle_id = #{id}")
    void delete(Integer id);
}
