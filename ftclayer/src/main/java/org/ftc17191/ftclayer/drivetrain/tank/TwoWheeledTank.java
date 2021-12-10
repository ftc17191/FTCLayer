package org.ftc17191.ftclayer.drivetrain.tank;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;

public class TwoWheeledTank {
    public MotorEx rightMotor;
    public MotorEx leftMotor;

    public TwoWheeledTank(HardwareMap hardwareMap,
                   String rightMotor,
                   String leftMotor) {
        this.rightMotor = new MotorEx(hardwareMap, rightMotor);
        this.leftMotor = new MotorEx(hardwareMap, leftMotor);
    }

    // Makes MotorEx's based on already existing DcMotors
    public TwoWheeledTank(DcMotorEx rightMotor,
                          DcMotorEx leftMotor) {
        this.rightMotor = new MotorEx(rightMotor);
        this.leftMotor = new MotorEx(leftMotor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    // Sets motor run mode
    public void setRunMode(DcMotor.RunMode mode) {
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
