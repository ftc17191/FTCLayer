package org.ftc17191.ftclayer.util;

public class Util {
    public static boolean toBoolean(float f) {
        return f != 0f;
    }

    public static int toInt(boolean b) {
        if (b) {
            return 1;
        } else {
            return 0;
        }
    }
}
