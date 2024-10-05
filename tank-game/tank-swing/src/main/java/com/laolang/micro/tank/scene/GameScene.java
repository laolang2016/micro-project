package com.laolang.micro.tank.scene;

import com.laolang.micro.tank.consts.GameConsts;
import com.laolang.micro.tank.consts.GameStateEnum;
import com.laolang.micro.tank.map.MapParser;
import com.laolang.micro.tank.map.Tiled;
import java.awt.Graphics;
import java.util.List;

/**
 * 游戏场景
 */
public class GameScene extends BaseScene {
    @Override
    public void update(Graphics g) {
        drawScorePanel(g);
        drawMap(g);
    }

    /**
     * 绘制背景
     */
    private void drawScorePanel(Graphics g) {
        g.setColor(GameConsts.GAME_SCENE_BACKGROUND);
        g.fillRect(0, 0, GameConsts.GAME_WIDTH, GameConsts.GAME_HEIGHT);
    }

    /**
     * 绘制地图
     */
    private void drawMap(Graphics g) {
        g.setColor(GameConsts.DEFAULT_BACKGROUND);
        g.fillRect(GameConsts.MAP_START_X, GameConsts.MAP_START_Y, GameConsts.MAP_END_X, GameConsts.MAP_END_Y);

        List<Tiled> tiledList = MapParser.parse("001");
        for (Tiled tiled : tiledList) {
            g.drawImage(tiled.getImage(), tiled.getX(), tiled.getY(), GameConsts.TILED_WIDTH, GameConsts.TILED_HEIGHT, null);
        }
    }


    @Override
    public String getSceneCode() {
        return GameStateEnum.PLAYING.getCode();
    }
}
