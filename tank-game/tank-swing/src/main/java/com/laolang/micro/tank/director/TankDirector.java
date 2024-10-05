package com.laolang.micro.tank.director;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 * 坦克大战导演
 */
public class TankDirector extends JFrame {

    public TankDirector() throws HeadlessException {
        init();
    }

    private void init() {
        setSize(800, 600);
        setResizable(false);
        setTitle("坦克大战-swig 版");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void show() {
        super.show();
    }
}
