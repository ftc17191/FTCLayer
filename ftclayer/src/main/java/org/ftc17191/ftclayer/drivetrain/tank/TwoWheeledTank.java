package org.ftc17191.ftclayer.drivetrain.tank;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;

/**
 * The type Two wheeled tank.
 */
public class TwoWheeledTank {
    /**
     * The Right motor.
     */
    public MotorEx rightMotor;
    /**
     * The Left motor.
     */
    public MotorEx leftMotor;

    /**
     * Instantiates a new Two wheeled tank.
     *
     * @param hardwareMap the hardware map
     * @param rightMotor  the right motor
     * @param leftMotor   the left motor
     */
    public TwoWheeledTank(HardwareMap hardwareMap,
                   String rightMotor,
                   String leftMotor) {
        this.rightMotor = new MotorEx(hardwareMap, rightMotor);
        this.leftMotor = new MotorEx(hardwareMap, leftMotor);
    }

    /**
     * Instantiates a new Two wheeled tank.
     *
     * @param rightMotor the right motor
     * @param leftMotor  the left motor
     */
// Makes MotorEx's based on already existing DcMotors
    public TwoWheeledTank(DcMotorEx rightMotor,
                          DcMotorEx leftMotor) {
        this.rightMotor = new MotorEx(rightMotor);
        this.leftMotor = new MotorEx(leftMotor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    /**
     * Sets run mode.
     *
     * @param mode the mode
     */
    public void setRunMode(DcMotor.RunMode mode) {
        rightMotor.dcMotor.setMode(mode);
        leftMotor.dcMotor.setMode(mode);
    }


    /**
     * Power drive.
     *
     * @param right_power the right power
     * @param left_power  the left power
     */
    public void powerDrive(double right_power, double left_power) {
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.dcMotor.setPower(right_power);
        leftMotor.dcMotor.setPower(left_power);
    }
}
