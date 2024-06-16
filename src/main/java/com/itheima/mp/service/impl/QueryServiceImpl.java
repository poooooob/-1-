package com.itheima.mp.service.impl;

import com.itheima.mp.domain.dto.queryDTO;
import com.itheima.mp.domain.vo.queryVo;
import com.itheima.mp.mapper.QueryMapper;
import com.itheima.mp.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryMapper queryMapper;
    @Override
    public List<queryVo> query(queryDTO queryDTO) {
        return queryMapper.query(queryDTO);
    }
}
