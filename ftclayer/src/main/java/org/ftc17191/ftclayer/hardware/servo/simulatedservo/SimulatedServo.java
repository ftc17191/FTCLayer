package org.ftc17191.ftclayer.hardware.servo.simulatedservo;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;

public class SimulatedServo {
    MotorEx motor;

    // Servo related vars
    double position;
    Servo.Direction direction;

    int minPositionTicks;
    int maxPositionTicks;


    SimulatedServo(HardwareMap hardwareMap, String id, int minPositionTicks, int maxPositionTicks) {
        motor = new MotorEx(hardwareMap, id);
        direction = Servo.Direction.FORWARD;
    }

    SimulatedServo(MotorEx motorEx, int minPositionTicks, int maxPositionTicks) {
        motor = motorEx;
        direction = Servo.Direction.FORWARD;
    }

    SimulatedServo(DcMotorEx dcMotor, int minPositionTicks, int maxPositionTicks) {
        motor = new MotorEx(dcMotor);
        direction = Servo.Direction.FORWARD;
    }

    /*
    The following functions are in the SDK, Basic getters and setters
    I've implemented them to keep this class like a servo.
     */
    Servo.Direction getDirection() {
        return direction;
    }

    public void setDirection(Servo.Direction direction) {
        this.direction = direction;
    }

    int getPortNumber() {
        return motor.dcMotor.getPortNumber();
    }

    double getPosition() {
        return position;
    }

    public void setPosition(double pos) {
        position = pos;
        int ticks;

        // "You are not expected to understand this."
        if (direction == Servo.Direction.FORWARD) {
            ticks = ((int) (Math.round(position) *
                    (maxPositionTicks - minPositionTicks)
                    + minPositionTicks));
        } else {
            ticks = ((int) (Math.round(position) *
                    (minPositionTicks - maxPositionTicks)
                    + maxPositionTicks));
        }

        motor.goToPosition(ticks);
    }

    // Not going to implement scaleRange yet, maybe later

}
