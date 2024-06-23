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
 * 车站表
 * </p>
 *
 * @author 泓陈
 * @since 2024-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("station")
public class Station implements Serializable {


    @TableId(value = "station_id", type = IdType.AUTO)
    private Integer stationId;

    private String stationName;

}
