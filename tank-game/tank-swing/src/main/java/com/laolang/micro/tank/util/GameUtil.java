package com.laolang.micro.tank.util;

import com.laolang.micro.tank.consts.GameConsts;
import com.laolang.micro.tank.consts.GameStateEnum;
import com.laolang.micro.tank.director.DirectorPanel;
import com.laolang.micro.tank.model.MenuModel;
import com.laolang.micro.tank.scene.BaseScene;
import com.laolang.micro.tank.scene.SceneFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * 游戏工具类和调度
 */
@Getter
public enum GameUtil {

    INSTANCE;

    GameUtil() {
        init();
    }

    private void init() {
        initMenu();
    }

    /**
     * 初始化菜单数据
     */
    private void initMenu() {
        menuList.add(new MenuModel(GameConsts.MENU_START, GameStateEnum.LAUNCH.getCode()));
        menuList.add(new MenuModel(GameConsts.MENU_CONTINUE, GameStateEnum.LAUNCH.getCode()));
        menuList.add(new MenuModel(GameConsts.MENU_HELP, GameStateEnum.LAUNCH.getCode()));
        menuList.add(new MenuModel(GameConsts.MENU_ABOUT, GameStateEnum.LAUNCH.getCode()));
        menuList.add(new MenuModel(GameConsts.MENU_EXIT, GameStateEnum.LAUNCH.getCode()));
    }

    private GameStateEnum gameState = GameStateEnum.LAUNCH;

    private final List<MenuModel> menuList = new ArrayList<>();

    private final Map<String, BaseScene> sceneMap = new HashMap<>();

    @Setter
    private DirectorPanel directorPanel;

    public void startGame() {
        toScene();
    }

    public void toScene() {
        toScene(gameState);
    }

    public void toScene(GameStateEnum gameState) {
        directorPanel.replaceScene(gameState);
    }

    public BaseScene getScene(GameStateEnum gameState) {
        String code = gameState.getCode();
        if (!sceneMap.containsKey(code)) {
            sceneMap.put(code, SceneFactory.build(code));
        }
        return sceneMap.get(code);
    }
}
