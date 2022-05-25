package org.ftc17191.ftclayer.util;

/**
 * The type Util.
 */
public class Util {
    /**
     * Float to boolean convertor.
     *
     * @param f the input
     * @return the boolean
     */
    public static boolean toBoolean(float f) {
        return f != 0f;
    }

    /**
     * Boolean to int convertor.
     *
     * @param b the b
     * @return the int
     */
    public static int toInt(boolean b) {
        if (b) {
            return 1;
        } else {
            return 0;
        }
    }
}
