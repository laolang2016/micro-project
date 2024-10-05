package com.laolang.micro.tank.model;

import com.laolang.micro.tank.consts.GameConsts;
import com.laolang.micro.tank.consts.GameStateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜单
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuModel {


    /**
     * 菜单文本
     *
     * @see GameConsts#MENU_START
     * @see GameConsts#MENU_CONTINUE
     * @see GameConsts#MENU_HELP
     * @see GameConsts#MENU_ABOUT
     * @see GameConsts#MENU_EXIT
     */
    private String menuText;

    /**
     * 场景编码
     *
     * @see GameStateEnum
     */
    private String action;
}
