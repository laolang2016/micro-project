package com.laolang.micro.tank.director;

import cn.hutool.core.util.StrUtil;
import com.laolang.micro.tank.consts.GameConsts;
import com.laolang.micro.tank.consts.GameStateEnum;
import com.laolang.micro.tank.scene.BaseScene;
import com.laolang.micro.tank.util.GameUtil;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.Objects;
import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;

/**
 * 导演面板
 */
@Slf4j
public class DirectorPanel extends JPanel {

    private BaseScene scene;

    public DirectorPanel() {
        super();
        setLayout(new BorderLayout());
        setBackground(GameConsts.DEFAULT_BACKGROUND);
    }

    /**
     * 替换场景
     */
    public void replaceScene(GameStateEnum gameState) {
        if (newScene(gameState)) {
            return;
        }
        if (Objects.nonNull(scene)) {
            scene = null;
        }
        setScene(GameUtil.INSTANCE.getScene(gameState));
        add(scene, BorderLayout.CENTER);
        repaint();
    }

    /**
     * 当前场景是否需要替换
     */
    private boolean newScene(GameStateEnum gameState) {
        if (Objects.isNull(scene)) {
            return false;
        }
        return StrUtil.equals(scene.getSceneCode(), gameState.getCode());
    }

    private void setScene(BaseScene scene) {
        this.scene = scene;
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        if (Objects.nonNull(scene)) {
            scene.update(g);
        }
    }
}
