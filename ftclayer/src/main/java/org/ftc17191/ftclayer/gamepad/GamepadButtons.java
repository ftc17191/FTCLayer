package org.ftc17191.ftclayer.gamepad;

/**
 * The type Gamepad buttons.
 */
public class GamepadButtons {
    /**
     * The enum Gamepad digital.
     */
    public enum GamepadDigital {
        /**
         * A gamepad digital.
         */
        A,
        /**
         * B gamepad digital.
         */
        B,
        /**
         * X gamepad digital.
         */
        X,
        /**
         * Y gamepad digital.
         */
        Y,  // Buttons
        /**
         * Left bumper gamepad digital.
         */
        LEFT_BUMPER,
        /**
         * Right bumper gamepad digital.
         */
        RIGHT_BUMPER, // If bumper pressed
        /**
         * Left trigger activated gamepad digital.
         */
        LEFT_TRIGGER_ACTIVATED,
        /**
         * Right trigger activated gamepad digital.
         */
        RIGHT_TRIGGER_ACTIVATED, // If the trigger is at a non-zero value
        /**
         * Left stick activated gamepad digital.
         */
        LEFT_STICK_ACTIVATED,
        /**
         * Right stick activated gamepad digital.
         */
        RIGHT_STICK_ACTIVATED, // If stick x or y is at a non-zero value
        /**
         * Left stick button gamepad digital.
         */
        LEFT_STICK_BUTTON,
        /**
         * Right stick button gamepad digital.
         */
        RIGHT_STICK_BUTTON,
        /**
         * Start gamepad digital.
         */
        START,
        /**
         * Back gamepad digital.
         */
        BACK,
        /**
         * Dpad up gamepad digital.
         */
        DPAD_UP,
        /**
         * Dpad down gamepad digital.
         */
        DPAD_DOWN,
        /**
         * Dpad left gamepad digital.
         */
        DPAD_LEFT,
        /**
         * Dpad right gamepad digital.
         */
        DPAD_RIGHT
    }

    /**
     * The enum Gamepad analog.
     */
    public enum GamepadAnalog {
        /**
         * Left trigger gamepad analog.
         */
        LEFT_TRIGGER,
        /**
         * Right trigger gamepad analog.
         */
        RIGHT_TRIGGER,
        /**
         * Left stick x gamepad analog.
         */
        LEFT_STICK_X,
        /**
         * Left stick y gamepad analog.
         */
        LEFT_STICK_Y,
        /**
         * Right stick x gamepad analog.
         */
        RIGHT_STICK_X,
        /**
         * Right stick y gamepad analog.
         */
        RIGHT_STICK_Y
    }
}
