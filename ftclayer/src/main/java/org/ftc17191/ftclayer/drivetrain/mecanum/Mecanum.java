package org.ftc17191.ftclayer.drivetrain.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;


@Disabled
public class Mecanum {
    public MotorEx frontRightMotor;
    public MotorEx frontLeftMotor;
    public MotorEx backRightMotor;
    public MotorEx backLeftMotor;

    public Mecanum(
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

    public Mecanum(
            HardwareMap hardwareMap,
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

    // Sets motor run mode
    private void setRunMode(DcMotor.RunMode mode) {
        frontRightMotor.dcMotor.setMode(mode);
        frontLeftMotor.dcMotor.setMode(mode);
        backRightMotor.dcMotor.setMode(mode);
        backLeftMotor.dcMotor.setMode(mode);
    }


    public void powerDrive(double forwardPower, double strafePower, double turningPower) {
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.dcMotor.setPower(-forwardPower - strafePower - turningPower);
        frontLeftMotor.dcMotor.setPower(forwardPower - strafePower - turningPower);
        backRightMotor.dcMotor.setPower(-forwardPower + strafePower - turningPower);
        backLeftMotor.dcMotor.setPower(forwardPower + strafePower - turningPower);
    }

}
