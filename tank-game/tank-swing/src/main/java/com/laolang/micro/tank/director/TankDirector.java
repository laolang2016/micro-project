package com.laolang.micro.tank.director;

import com.laolang.micro.tank.consts.GameConsts;
import com.laolang.micro.tank.util.GameUtil;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import lombok.extern.slf4j.Slf4j;

/**
 * 坦克大战导演
 */
@Slf4j
public class TankDirector extends JFrame {

    private DirectorPanel directorPanel;

    public TankDirector() throws HeadlessException {
        initFrame();
        initGame();
    }

    private void initFrame() {
        setSize(GameConsts.GAME_WIDTH, GameConsts.GAME_HEIGHT);
        setResizable(false);
        setTitle(GameConsts.GAME_TITLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

    }

    private void initGame() {
        directorPanel = new DirectorPanel();
        getContentPane().add(directorPanel, BorderLayout.CENTER);

        GameUtil.INSTANCE.setDirectorPanel(directorPanel);
    }

    /**
     * 开始游戏
     */
    public void startGame() {
        setVisible(true);
        GameUtil.INSTANCE.startGame();
    }
}
