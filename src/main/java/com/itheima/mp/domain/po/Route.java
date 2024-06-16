package com.itheima.mp.domain.po;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 线路表
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("route")
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "route_id", type = IdType.AUTO)
    private Integer routeId;


    private String routeName;

    private Integer routeStart;

    private Integer routeEnd;

}
