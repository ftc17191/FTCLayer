package org.ftc17191.ftclayer.gamepad;

public class GamepadButtons {
    public enum GamepadDigital {
        A, B, X, Y,  // Buttons
        LEFT_BUMPER, RIGHT_BUMPER, // If bumper pressed
        LEFT_TRIGGER_ACTIVATED, RIGHT_TRIGGER_ACTIVATED, // If the trigger is at a non-zero value
        LEFT_STICK_ACTIVATED, RIGHT_STICK_ACTIVATED, // If stick x or y is at a non-zero value
        LEFT_STICK_BUTTON, RIGHT_STICK_BUTTON,
        START, BACK,
        DPAD_UP, DPAD_DOWN, DPAD_LEFT, DPAD_RIGHT
    }

    public enum GamepadAnalog {
        LEFT_TRIGGER, RIGHT_TRIGGER,
        LEFT_STICK_X, LEFT_STICK_Y,
        RIGHT_STICK_X, RIGHT_STICK_Y
    }
}
