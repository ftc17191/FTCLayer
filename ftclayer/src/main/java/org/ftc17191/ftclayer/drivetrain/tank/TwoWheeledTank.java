package org.ftc17191.ftclayer.drivetrain.tank;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;

public class TwoWheeledTank {
    public MotorEx rightMotor;
    public MotorEx leftMotor;

    TwoWheeledTank(HardwareMap hardwareMap,
                   String right_motor,
                   String left_motor) {
        rightMotor = new MotorEx(hardwareMap, right_motor);
        leftMotor = new MotorEx(hardwareMap, left_motor);
    }

    // Makes MotorEx's based on already existing DcMotors
    public TwoWheeledTank(DcMotorEx right_motor,
                          DcMotorEx left_motor) {
        rightMotor = new MotorEx(right_motor);
        leftMotor = new MotorEx(left_motor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    // Sets motor run mode
    private void setRunMode(DcMotor.RunMode mode) {
        rightMotor.dcMotor.setMode(mode);
        leftMotor.dcMotor.setMode(mode);
    }


    // Drives based on 2 power statements
    public void powerDrive(double right_power, double left_power) {
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.dcMotor.setPower(right_power);
        leftMotor.dcMotor.setPower(left_power);
    }
}
