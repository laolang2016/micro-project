package com.laolang.micro.tank.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 瓦片地图 layer 数据
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LayerCsvModel {

    /**
     * id , 也是地图层级, 数字越小, 则层叠级别越小
     */
    private String id;
    /**
     * layer csv 数据
     */
    private String data;
}
