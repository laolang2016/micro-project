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

    public void replaceScene(GameStateEnum gameState) {
        if (matchScene(gameState)) {
            return;
        }

        setScene(GameUtil.INSTANCE.getScene(gameState));
        add(scene, BorderLayout.CENTER);
        repaint();
    }

    private boolean matchScene(GameStateEnum gameState) {
        if (Objects.isNull(scene)) {
            return false;
        }
        return StrUtil.equals(scene.getSceneCode(), gameState.getCode());
    }

    private void setScene(BaseScene scene) {
        this.scene = scene;
    }

    @Override
    public void update(Graphics g) {
        if (Objects.nonNull(scene)) {
            scene.update(g);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        update(g);
    }
}
