package com.itheima.mp.mapper;

import com.itheima.mp.domain.po.Station;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 车站表 Mapper 接口
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Mapper
public interface StationMapper  {



    @Insert("insert into station(station_name) values(#{stationName})")
    void add(Station station);

    @Delete("delete from station where station_id = #{id}")
    void deleteById(Integer id);

    //@Select("select * from station")
    List<Station> list();
}
