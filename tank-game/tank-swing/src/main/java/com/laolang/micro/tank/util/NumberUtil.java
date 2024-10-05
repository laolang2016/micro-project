package com.laolang.micro.tank.util;

public class NumberUtil {

    /**
     * 数字是否为奇数
     */
    public static boolean isOddNumber(int num) {
        return 1 == (num & 1);
    }

    /**
     * 数字是否为偶数
     */
    public static boolean isEvenNumber(int num) {
        return !isOddNumber(num);
    }
}
