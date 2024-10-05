package com.laolang.micro.tank.scene;

import com.laolang.micro.tank.consts.GameConsts;
import com.laolang.micro.tank.consts.GameStateEnum;
import com.laolang.micro.tank.model.MenuModel;
import com.laolang.micro.tank.util.GameUtil;
import com.laolang.micro.tank.util.NumberUtil;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 开始场景
 */
@Slf4j
public class LaunchScene extends BaseScene {

    /**
     * 选中的菜单索引
     */
    @Setter
    @Getter
    private Integer menuActiveIndex = 0;

    public LaunchScene() {
        super();
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new LaunchSceneKeyAdapter(this));
    }

    @Override
    public String getSceneCode() {
        return GameStateEnum.LAUNCH.getCode();
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        drawBackground(g);
        drawMenu(g);
        requestFocusInWindow();
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
        g.setFont(GameConsts.MENU_FONT);

        drawHelpText(g);

        g.setColor(Color.white);

        int textHeight = getTextHeight(g, GameUtil.INSTANCE.getMenuList().get(0).getMenuText());
        int spaceHeight = 30;
        int offsetY = textHeight + spaceHeight;
        int firstY = getFirstMenuDirection(textHeight, spaceHeight, GameUtil.INSTANCE.getMenuList().size());
        firstY = GameConsts.GAME_HEIGHT / 2 - firstY;


        for (int i = 0; i < GameUtil.INSTANCE.getMenuList().size(); i++) {

            if (i == menuActiveIndex) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.white);
            }

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
     * 绘制帮助文本
     */
    private void drawHelpText(Graphics g) {
        g.setColor(Color.yellow);
        String text = GameConsts.MENU_TIP_TEXT;
        int textWidth = getTextWidth(g, text);
        int x = (GameConsts.GAME_WIDTH - textWidth) / 2;
        int y = 30;
        g.drawString(text, x, y);
    }

    /**
     * 获取文本高度
     */
    private int getTextHeight(Graphics g, String text) {
        FontMetrics metrics = g.getFontMetrics();
        return metrics.getAscent();
    }

    /**
     * 获取文本宽度
     *
     * @param g
     * @param text
     * @return
     */
    private int getTextWidth(Graphics g, String text) {
        FontMetrics metrics = g.getFontMetrics();
        return metrics.stringWidth(text);
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

    @Slf4j
    @RequiredArgsConstructor
    static class LaunchSceneKeyAdapter extends KeyAdapter {

        private final LaunchScene scene;

        @Override
        public void keyReleased(KeyEvent e) {
            int index = scene.getMenuActiveIndex();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W: {
                    index = 0 == index ? GameUtil.INSTANCE.getMenuList().size() - 1 : index - 1;
                    break;
                }
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S: {
                    index = index == GameUtil.INSTANCE.getMenuList().size() - 1 ? 0 : index + 1;
                    break;
                }
                case KeyEvent.VK_ENTER:
                case KeyEvent.VK_J: {
                    log.info("action");
                    break;
                }
            }
            scene.setMenuActiveIndex(index);
            scene.repaint();
        }
    }
}
