package org.ftc17191.ftclayer.kgmotion.localization;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;
import org.ftc17191.ftclayer.kgmotion.motion.Position;
import org.ftc17191.ftclayer.util.Util;

import java.sql.Array;

import static java.lang.Math.*;

public class ThreeWheelOdometry implements LocalizationMethod {
    // Massive props to Team 5225 E-Bots pilons. Those guys are amazing.
    // Like, writing professional-grade papers for Vex Competitions, amazing.

    DcMotorEx right;
    DcMotorEx left;
    DcMotorEx back;

    double initial_x;
    double initial_y;
    double initial_rotation; // Stored as radians

    int last_right_ticks = 0;
    int last_left_ticks = 0;
    int last_back_ticks = 0;

    double last_x;
    double last_y;
    double last_rotation; // Stored as radians

    double distance_right; // Distance from right enc to center
    double distance_left; // Same as above
    double distance_back; // Same as above

    double ticks_to_rotation;
    double wheel_circumference;

    public ThreeWheelOdometry(HardwareMap hardwareMap, String right, String left,
                              String back, double ticks_to_rotation, double wheel_circumference,
                              double initial_x, double initial_y, double initial_rotation,
                              double distance_right, double distance_left, double distance_back)
    {
        // Set up encoders
        this.right = hardwareMap.get(DcMotorEx.class, right);
        this.left = hardwareMap.get(DcMotorEx.class, left);
        this.back = hardwareMap.get(DcMotorEx.class, back);

        // Set up vars
        this.initial_x = initial_x;
        this.initial_y = initial_y;
        this.initial_rotation = Math.toRadians(initial_rotation);

        this.ticks_to_rotation = ticks_to_rotation;
        this.wheel_circumference = wheel_circumference;

        this.distance_right = distance_right;
        this.distance_left = distance_left;
        this.distance_back = distance_back;

        this.last_x = this.initial_x;
        this.last_y = this.initial_y;
        this.last_rotation = this.initial_rotation;


    }

    @Override
    public Position getPosition() {
        int right_ticks = right.getCurrentPosition();
        int left_ticks = left.getCurrentPosition();
        int back_ticks = back.getCurrentPosition();

        int delta_right_ticks = right_ticks - last_right_ticks;
        int delta_left_ticks = left_ticks - last_left_ticks;
        int delta_back_ticks = back_ticks - last_back_ticks;

        last_right_ticks = right_ticks;
        last_left_ticks = left_ticks;
        last_back_ticks = back_ticks;

        double right_distance = delta_right_ticks / ticks_to_rotation * wheel_circumference;
        double left_distance = -delta_left_ticks / ticks_to_rotation * wheel_circumference;


        double delta_rotation = -(left_distance - right_distance) / (distance_left + distance_right);

        double dxr = -delta_back_ticks / ticks_to_rotation * wheel_circumference;
        double dyr = .5 * (right_distance + left_distance);
        double sin = Math.sin(last_rotation + (delta_rotation / 2));
        double cos = Math.cos(last_rotation + (delta_rotation / 2));

        double current_x = (dxr * sin + dyr * -cos) + last_x;
        double current_y = (dxr * cos + dyr * sin) + last_y;
        double current_rotation = last_rotation + delta_rotation;

        last_rotation = current_rotation;
        last_x = current_x;
        last_y = current_y;
        return new Position(current_x, current_y, Math.toDegrees(current_rotation));
    }

}
