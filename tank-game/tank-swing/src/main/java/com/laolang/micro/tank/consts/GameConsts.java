package com.laolang.micro.tank.consts;

import java.awt.Color;
import java.awt.Font;
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
    public static final Integer GAME_HEIGHT = 720;

    /**
     * 默认背景色
     */
    public static final Color DEFAULT_BACKGROUND = Color.black;

    /**
     * 菜单文本
     */
    public static final String MENU_START = "开始游戏";
    public static final String MENU_CONTINUE = "继续游戏";
    public static final String MENU_HELP = "游戏帮助";
    public static final String MENU_ABOUT = "游戏关于";
    public static final String MENU_EXIT = "退出游戏";

    /**
     * 菜单字体
     */
    public static final Font MENU_FONT = new Font("宋体", Font.BOLD, 24);

}
