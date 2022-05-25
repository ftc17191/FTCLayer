package org.ftc17191.ftclayer.drivetrain.tank;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;


/**
 * The Four wheeled tank drivetrain.
 */
public class FourWheeledTank {
    /**
     * The Front right motor.
     */
    public MotorEx frontRightMotor;
    /**
     * The Front left motor.
     */
    public MotorEx frontLeftMotor;
    /**
     * The Back right motor.
     */
    public MotorEx backRightMotor;
    /**
     * The Back left motor.
     */
    public MotorEx backLeftMotor;


    /**
     * Instantiates a new Four wheeled tank.
     *
     * @param hardwareMap     the hardware map
     * @param frontRightMotor the front right motor
     * @param frontLeftMotor  the front left motor
     * @param backRightMotor  the back right motor
     * @param backLeftMotor   the back left motor
     */
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


    /**
     * Instantiates a new Four wheeled tank.
     *
     * @param frontRightMotor the front right motor
     * @param frontLeftMotor  the front left motor
     * @param backRightMotor  the back right motor
     * @param backLeftMotor   the back left motor
     */
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


    /**
     * Sets run mode for all 4 motors.
     *
     * @param mode the mode
     */
    public void setRunMode(DcMotor.RunMode mode) {
        frontRightMotor.setMode(mode);
        frontLeftMotor.setMode(mode);
        backRightMotor.setMode(mode);
        backLeftMotor.setMode(mode);
    }


    /**
     * Power drive.
     *
     * @param right_power the right power
     * @param left_power  the left power
     */
    public void powerDrive(double right_power, double left_power) {
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setPower(right_power);
        frontLeftMotor.setPower(left_power);
        backRightMotor.setPower(right_power);
        backLeftMotor.setPower(left_power);
    }
}
