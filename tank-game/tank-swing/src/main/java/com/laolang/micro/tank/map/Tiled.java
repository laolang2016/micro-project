package com.laolang.micro.tank.map;

import java.awt.image.BufferedImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地图瓦片
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tiled {


    /**
     * 瓦片 x 坐标
     */
    private Integer x;

    /**
     * 瓦片 y 坐标
     */
    private Integer y;

    /**
     * 瓦片图片名称
     */
    private String name;

    /**
     * 瓦片图片
     */
    private BufferedImage image;

    /**
     * layer 层级
     */
    private Integer layer;
}
