package com.laolang.micro.tank;

import com.google.common.collect.Lists;
import com.laolang.micro.tank.map.MapParser;
import com.laolang.micro.tank.map.Tiled;
import java.util.List;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class CommonTest {

    @SneakyThrows
    @Test
    public void testOne() {
        List<Tiled> tiledList = MapParser.parse("001");
        for (Tiled tiled : tiledList) {
            System.out.println(tiled.toString());
        }
    }

    @Test
    public void testTwo() {
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < 26 * 26; i++) {
            list.add("0");
        }
        String[][] arr = new String[26][26];
        for (int i = 0; i < list.size(); i++) {
            arr[i / 26][i % 26] = list.get(i);
        }

    }
}
