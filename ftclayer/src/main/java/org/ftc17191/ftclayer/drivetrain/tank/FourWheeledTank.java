package org.ftc17191.ftclayer.drivetrain.tank;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;


@Disabled
public class FourWheeledTank {
    // Motors
    public MotorEx frontRightMotor;
    public MotorEx frontLeftMotor;
    public MotorEx backRightMotor;
    public MotorEx backLeftMotor;


    // Takes in 4 ids and hardware map, makes MotorEx's based on ids.
    public FourWheeledTank(HardwareMap hardwareMap,
                           String frontRightMotor,
                           String frontLeftMotor,
                           String backRightMotor,
                           String backLeftMotor) {
        this.frontRightMotor = new MotorEx(hardwareMap, frontRightMotor);
        this.frontLeftMotor = new MotorEx(hardwareMap, frontLeftMotor);
        this.backRightMotor = new MotorEx(hardwareMap, backRightMotor);
        this.backLeftMotor = new MotorEx(hardwareMap, backLeftMotor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    // Makes MotorEx's based on already existing DcMotors
    public FourWheeledTank(
            DcMotorEx frontRightMotor,
            DcMotorEx frontLeftMotor,
            DcMotorEx backRightMotor,
            DcMotorEx backLeftMotor) {
        this.frontRightMotor = new MotorEx(frontRightMotor);
        this.frontLeftMotor = new MotorEx(frontLeftMotor);
        this.backRightMotor = new MotorEx(backRightMotor);
        this.backLeftMotor = new MotorEx(backLeftMotor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    // Sets motor run mode
    private void setRunMode(DcMotor.RunMode mode) {
        frontRightMotor.dcMotor.setMode(mode);
        frontLeftMotor.dcMotor.setMode(mode);
        backRightMotor.dcMotor.setMode(mode);
        backLeftMotor.dcMotor.setMode(mode);
    }


    // Drives based on 2 power statements
    public void powerDrive(double right_power, double left_power) {
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.dcMotor.setPower(right_power);
        frontLeftMotor.dcMotor.setPower(left_power);
        backRightMotor.dcMotor.setPower(right_power);
        backLeftMotor.dcMotor.setPower(left_power);
    }
}
