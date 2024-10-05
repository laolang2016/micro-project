package com.laolang.micro.tank.scene;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * 创景创建工厂
 */
@Slf4j
@UtilityClass
public class SceneFactory {

    public BaseScene build(String code) {
        BaseScene scene = null;
        switch (code) {
            case "launch": {
                scene = new LaunchScene();
                break;
            }
            case "playing": {
                scene = new GameScene();
                break;
            }
            default: {
                log.error("未知的场景, 游戏退出");
            }
        }

        return scene;
    }
}
