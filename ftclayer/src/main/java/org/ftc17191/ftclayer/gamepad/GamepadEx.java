package org.ftc17191.ftclayer.gamepad;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.internal.ui.GamepadUser;
import org.ftc17191.ftclayer.util.Util;


public class GamepadEx {

    Gamepad gamepad = new Gamepad();

    public GamepadEx(GamepadUser user) {
        gamepad.setUser(user);
    }


    public boolean isButtonActivated(GamepadButtons.GamepadDigital button) {


        switch (button) {
            case A:
                return gamepad.a;


            case B:
                return gamepad.b;


            case X:
                return gamepad.x;


            case Y:
                return gamepad.y;


            case DPAD_UP:
                return gamepad.dpad_up;


            case DPAD_DOWN:
                return gamepad.dpad_down;


            case DPAD_LEFT:
                return gamepad.dpad_left;


            case DPAD_RIGHT:
                return gamepad.dpad_right;


            case LEFT_STICK_BUTTON:
                return gamepad.left_stick_button;


            case RIGHT_STICK_BUTTON:
                return gamepad.right_stick_button;


            case START:
                return gamepad.start;


            case BACK:
                return gamepad.back;


            case LEFT_BUMPER:
                return gamepad.left_bumper;


            case RIGHT_BUMPER:
                return gamepad.right_bumper;


            case RIGHT_STICK_ACTIVATED:
                return Util.toBoolean(gamepad.right_stick_x) ^ Util.toBoolean(gamepad.right_stick_y);


            case LEFT_STICK_ACTIVATED:
                return Util.toBoolean(gamepad.left_stick_x) ^ Util.toBoolean(gamepad.left_stick_y);


            case RIGHT_TRIGGER_ACTIVATED:
                return Util.toBoolean(gamepad.right_trigger);


            case LEFT_TRIGGER_ACTIVATED:
                return Util.toBoolean(gamepad.left_trigger);

        }
        return false;
    }

    public float getAnalogFloat(GamepadButtons.GamepadAnalog analog) {
        switch (gamepad.getUser()) {
            case ONE:
                switch (analog) {
                    case LEFT_STICK_X:
                        return gamepad.left_stick_x;
                    case LEFT_STICK_Y:
                        return gamepad.left_stick_y;
                    case RIGHT_STICK_X:
                        return gamepad.right_stick_x;
                    case RIGHT_STICK_Y:
                        return gamepad.right_stick_y;
                    case RIGHT_TRIGGER:
                        return gamepad.right_trigger;
                    case LEFT_TRIGGER:
                        return gamepad.left_trigger;

                }


            case TWO:
                switch (analog) {
                    case LEFT_STICK_X:
                        return gamepad.left_stick_x;
                    case LEFT_STICK_Y:
                        return gamepad.left_stick_y;
                    case RIGHT_STICK_X:
                        return gamepad.right_stick_x;
                    case RIGHT_STICK_Y:
                        return gamepad.right_stick_y;
                    case RIGHT_TRIGGER:
                        return gamepad.right_trigger;
                    case LEFT_TRIGGER:
                        return gamepad.left_trigger;
                }
        }
        return 0;
    }
}
