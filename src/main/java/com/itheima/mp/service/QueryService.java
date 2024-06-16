package com.itheima.mp.service;

import com.itheima.mp.domain.dto.queryDTO;
import com.itheima.mp.domain.po.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.vo.queryVo;

import java.util.List;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
public interface QueryService {

    List<queryVo> query(queryDTO queryDTO);
}
