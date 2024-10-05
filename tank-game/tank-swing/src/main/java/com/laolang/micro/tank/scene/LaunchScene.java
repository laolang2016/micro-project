package com.laolang.micro.tank.scene;

import com.laolang.micro.tank.consts.GameConsts;
import com.laolang.micro.tank.consts.GameStateEnum;
import com.laolang.micro.tank.model.MenuModel;
import com.laolang.micro.tank.util.GameUtil;
import com.laolang.micro.tank.util.NumberUtil;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import lombok.extern.slf4j.Slf4j;

/**
 * 开始场景
 */
@Slf4j
public class LaunchScene extends BaseScene {

    public LaunchScene() {
        super();
    }

    @Override
    public String getSceneCode() {
        return GameStateEnum.LAUNCH.getCode();
    }

    @Override
    public void update(Graphics g) {
        drawBackground(g);
        drawMenu(g);
    }

    /**
     * 绘制背景
     */
    private void drawBackground(Graphics g) {
        g.setColor(GameConsts.DEFAULT_BACKGROUND);
        g.fillRect(0, 0, GameConsts.GAME_WIDTH, GameConsts.GAME_HEIGHT);
    }

    /**
     * 绘制菜单
     */
    private void drawMenu(Graphics g) {
        g.setColor(Color.white);
        g.setFont(GameConsts.MENU_FONT);

        int textHeight = getTextHeight(g, GameUtil.INSTANCE.getMenuList().get(0).getMenuText());
        int spaceHeight = 30;
        int offsetY = textHeight + spaceHeight;
        int firstY = getFirstMenuDirection(textHeight, spaceHeight, GameUtil.INSTANCE.getMenuList().size());
        firstY = GameConsts.GAME_HEIGHT / 2 - firstY;


        for (int i = 0; i < GameUtil.INSTANCE.getMenuList().size(); i++) {
            MenuModel menuModel = GameUtil.INSTANCE.getMenuList().get(i);
            String text = menuModel.getMenuText();
            FontMetrics metrics = g.getFontMetrics();
            int textWidth = metrics.stringWidth(text);

            int x = (GameConsts.GAME_WIDTH - textWidth) / 2;
            int y = firstY + i * offsetY;

            g.drawString(text, x, y);
        }
    }

    /**
     * 获取文本高度
     */
    private int getTextHeight(Graphics g, String text) {
        FontMetrics metrics = g.getFontMetrics();
        return metrics.getAscent();
    }

    /**
     * 返回第一个菜单的 y 坐标偏移量, 此偏移量以游戏中心为原点, 向上的偏移量
     *
     * @param textHeight  文本高度
     * @param spaceHeight 间距高度
     * @param menuSize    菜单数量
     * @return y 坐标和偏移量
     */
    private int getFirstMenuDirection(Integer textHeight, Integer spaceHeight, Integer menuSize) {
        // 奇数个菜单
        if (NumberUtil.isOddNumber(menuSize)) {

            int halfCount = menuSize / 2;
            return halfCount * textHeight + halfCount * spaceHeight + textHeight / 2;
        }
        // 偶数个菜单
        int halfCount = menuSize / 2;
        return halfCount * textHeight + (halfCount - 1) * spaceHeight + spaceHeight / 2;
    }

}
