package com.laolang.micro.tank.consts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 当前游戏状态
 */
@Getter
@RequiredArgsConstructor
public enum GameStateEnum {

    LAUNCH("launch"),
    HELP("help"),
    ABOUT("about"),
    PLAYING("playing"),
    FINISHED("finished");

    private final String code;

}
