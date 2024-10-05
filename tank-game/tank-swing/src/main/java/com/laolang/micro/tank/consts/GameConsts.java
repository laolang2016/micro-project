package com.laolang.micro.tank.consts;

import com.laolang.micro.tank.util.IoUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import lombok.experimental.UtilityClass;

/**
 * 全局常量
 */
@UtilityClass
public class GameConsts {

    /**
     * 游戏标题
     */
    public static final String GAME_TITLE = "坦克大战-swig 版";
    /**
     * 游戏宽度
     */
    public static final Integer GAME_WIDTH = 768;
    /**
     * 游戏高度
     */
    public static final Integer GAME_HEIGHT = 748;

    /**
     * 刷新时间间隔
     */
    public static final long DELTA_TIME = 30;

    /**
     * 瓦片宽度
     */
    public static final int TILED_WIDTH = 24;

    /**
     * 瓦片宽度
     */
    public static final int TILED_HEIGHT = 24;

    /**
     * 瓦片地图宽度
     */
    public static final int TILED_MAP_WITDH = 26;

    /**
     * 地图范围
     */
    public static final int MAP_START_X = TILED_WIDTH * 2;
    public static final int MAP_START_Y = TILED_HEIGHT * 2;
    public static final int MAP_END_X = TILED_WIDTH * 13 * 2;
    public static final int MAP_END_Y = TILED_HEIGHT * 13 * 2;

    /**
     * 地图 brick xpath
     */
    public static final String MAP_XPATH_BRICK = "/map/layer[@name='brick']/data";
    /**
     * 地图 stone xpath
     */
    public static final String MAP_XPATH_STONE = "/map/layer[@name='stone']/data";

    /**
     * 砖块名称
     */
    public static final String TILED_NAME_BRICK = "brick";
    /**
     * 砖块图片
     */
    public static final BufferedImage TILED_IMAGE_BRICK = IoUtil.getImage("/textures/map/brick.png");

    /**
     * 石头名称
     */
    public static final String TILED_NAME_STONE = "stone";
    /**
     * 石头图片
     */
    public static final BufferedImage TILED_IMAGE_STONE = IoUtil.getImage("/textures/map/stone.png");

    /**
     * 默认背景色
     */
    public static final Color DEFAULT_BACKGROUND = Color.black;

    /**
     * 游戏场景背景色
     */
    public static final Color GAME_SCENE_BACKGROUND = new Color(127, 127, 127);

    /**
     * 菜单文本
     */
    public static final String MENU_START = "开始游戏";
    public static final String MENU_CONTINUE = "继续游戏";
    public static final String MENU_HELP = "游戏帮助";
    public static final String MENU_ABOUT = "游戏关于";
    public static final String MENU_EXIT = "退出游戏";
    public static final String MENU_TIP_TEXT = "按 W/S 或者方向键上下选择, 按 J 或 Enter 进入菜单";

    /**
     * 菜单字体
     */
    public static final Font MENU_FONT = new Font("宋体", Font.BOLD, 24);

}
