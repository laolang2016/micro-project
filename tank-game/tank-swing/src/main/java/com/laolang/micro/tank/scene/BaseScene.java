package com.laolang.micro.tank.scene;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 场景基类
 */
public abstract class BaseScene extends JPanel {

    public BaseScene() {
        super();
    }

    @Override
    public abstract void update(Graphics g);

    public abstract String getSceneCode();
}
