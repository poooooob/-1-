package com.itheima.mp.controller;


import com.itheima.mp.domain.dto.queryDTO;
import com.itheima.mp.domain.vo.Result;
import com.itheima.mp.domain.vo.queryVo;
import com.itheima.mp.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 综合查询 前端控制器
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService queryService;
    //综合查询
    @PostMapping("/getAll")
    public Result query(@RequestBody queryDTO queryDTO ){
        List<queryVo> list = queryService.query(queryDTO);
        return Result.success(list);
    }
}
