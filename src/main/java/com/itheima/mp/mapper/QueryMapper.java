package com.itheima.mp.mapper;

import com.itheima.mp.domain.dto.queryDTO;
import com.itheima.mp.domain.vo.queryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 综合查询 Mapper 接口
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Mapper
public interface QueryMapper {


    List<queryVo> query(queryDTO queryDTO);
}
