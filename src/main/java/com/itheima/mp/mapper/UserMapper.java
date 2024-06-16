package com.itheima.mp.mapper;

import com.itheima.mp.domain.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> list();

    @Delete("delete from user where user_id = #{id}")
    void removeById(Integer id);
}
