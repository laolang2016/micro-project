package com.laolang.micro.tank;

import com.laolang.micro.tank.director.TankDirector;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TankSwingApplication {
    public static void main(String[] args) {
        TankDirector tank = new TankDirector();
        tank.startGame();
    }
}
