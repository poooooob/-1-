package com.itheima.mp.mapper;

import com.itheima.mp.domain.dto.loginDTO;
import com.itheima.mp.domain.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

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



    void saveAll(List<User> userList);

    @Select("select * from user where user_account = #{userAccount} and user_password = #{userPassword}")
    User login(loginDTO loginDTO);

    @Select("select * from user where user_id = #{userId}")
    User findUserById(Integer userId);

    @Update("update user set user_id_card=#{userIdCard},user_name=#{userName},user_is_verified=#{userIsVerified}, user_phone=#{userPhone},user_account = #{userAccount}, user_location = #{userLocation} where user_id = #{userId}")
    void updateUser(User user);
}
