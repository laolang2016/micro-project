package com.laolang.micro.tank.util;

import java.awt.image.BufferedImage;
import java.util.Objects;
import javax.imageio.ImageIO;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class IoUtil {

    @SneakyThrows
    public static BufferedImage getImage(String path) {
        return ImageIO.read(Objects.requireNonNull(IoUtil.class.getResource(path)));
    }
}
