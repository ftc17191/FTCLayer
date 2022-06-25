package org.ftc17191.ftclayer.drivetrain.mecanum;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.imu.RevImu;
import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;


/**
 * The type Mecanum.
 */
public class Mecanum {

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
     * The Imu.
     */
    public RevImu imu = null;


    /**
     * Instantiates a new Mecanum.
     *
     * @param frontRightMotor the front right motor
     * @param frontLeftMotor  the front left motor
     * @param backRightMotor  the back right motor
     * @param backLeftMotor   the back left motor
     */
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

    /**
     * Instantiates a new Mecanum.
     *
     * @param hardwareMap     the hardware map
     * @param frontRightMotor the front right motor
     * @param frontLeftMotor  the front left motor
     * @param backRightMotor  the back right motor
     * @param backLeftMotor   the back left motor
     */
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

    /**
     * Instantiates a new Mecanum that can use powerAbsoluteDrive.
     *
     * @param frontRightMotor the front right motor
     * @param frontLeftMotor  the front left motor
     * @param backRightMotor  the back right motor
     * @param backLeftMotor   the back left motor
     * @param imu             the imu
     */
    public Mecanum(
            DcMotorEx frontRightMotor,
            DcMotorEx frontLeftMotor,
            DcMotorEx backRightMotor,
            DcMotorEx backLeftMotor,
            RevImu imu) {
        this.frontRightMotor = new MotorEx(frontRightMotor);
        this.frontLeftMotor = new MotorEx(frontLeftMotor);
        this.backRightMotor = new MotorEx(backRightMotor);
        this.backLeftMotor = new MotorEx(backLeftMotor);
        this.imu = imu;
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    /**
     * Instantiates a new Mecanum that can use powerAbsoluteDrive.
     *
     * @param hardwareMap     the hardware map
     * @param frontRightMotor the front right motor
     * @param frontLeftMotor  the front left motor
     * @param backRightMotor  the back right motor
     * @param backLeftMotor   the back left motor
     * @param imu             the imu
     */
    public Mecanum(
            HardwareMap hardwareMap,
            String frontRightMotor,
            String frontLeftMotor,
            String backRightMotor,
            String backLeftMotor,
            String imu) {

        this.frontRightMotor = new MotorEx(hardwareMap, frontRightMotor);
        this.frontLeftMotor = new MotorEx(hardwareMap, frontLeftMotor);
        this.backRightMotor = new MotorEx(hardwareMap, backRightMotor);
        this.backLeftMotor = new MotorEx(hardwareMap, backLeftMotor);
        this.imu = new RevImu(hardwareMap, imu);
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
     * Power based driving.
     *
     * @param forwardPower the forward power
     * @param strafePower  the strafe power
     * @param turningPower the turning power
     */
    public void powerDrive(double forwardPower, double strafePower, double turningPower) {
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setPower(-forwardPower - strafePower - turningPower);
        frontLeftMotor.setPower(forwardPower - strafePower - turningPower);
        backRightMotor.setPower(-forwardPower + strafePower - turningPower);
        backLeftMotor.setPower(forwardPower + strafePower - turningPower);
    }

    /**
     * Power absolute drive. Uses the Imu to have independent translation and orientation.
     *
     * @param forwardPower the forward power
     * @param strafePower  the strafe power
     * @param turningPower the turning power
     */
    public void powerAbsoluteDrive(double forwardPower, double strafePower, double turningPower)
    {
        // This calculates the powers based off the position of the imu given earlier.

        // Turning is kept the same, as its the same movement no matter the heading
        // Check if the imu was specified
        if (imu != null)
        {
            double calculatedForwardPower, calculatedStrafePower;
            double heading = imu.getHeadingRadians();

            calculatedForwardPower = forwardPower * Math.cos(heading)
                    + -strafePower * Math.sin(heading);
            calculatedStrafePower = forwardPower * Math.sin(heading)
                    + -strafePower * Math.cos(heading);
            powerDrive(calculatedForwardPower,calculatedStrafePower, turningPower);
        } else {
            powerDrive(0, 0, 0);
        }
    }

    /**
     * Power absolute drive. Uses the Imu to have independent translation and orientation.
     *
     * @param forwardPower the forward power
     * @param strafePower  the strafe power
     * @param turningPower the turning power
     * @param heading      the current heading in degrees
     */
    public void powerAbsoluteDrive(double forwardPower, double strafePower, double turningPower, double heading)
    {
        // This calculates the powers based off the position of the imu given earlier.

        // Turning is kept the same, as its the same movement no matter the heading
        // Check if the imu was specified
        if (imu != null)
        {
            double calculatedForwardPower, calculatedStrafePower;
            heading = Math.toRadians(heading);

            calculatedForwardPower = forwardPower * Math.cos(heading)
                    + strafePower * Math.sin(heading);
            calculatedStrafePower = -forwardPower * Math.sin(heading)
                    + strafePower * Math.cos(heading);
            powerDrive(calculatedForwardPower,calculatedStrafePower, turningPower);
        } else {
            powerDrive(0, 0, 0);
        }
    }

    /**
     * Power absolute drive. Uses the Imu to have independent translation and orientation.
     *
     * @param forwardPower the forward power
     * @param strafePower  the strafe power
     * @param turningPower the turning power
     * @param heading      the current heading in radians
     */
    public void powerAbsoluteDriveRadians(double forwardPower, double strafePower, double turningPower, double heading)
    {
        // This calculates the powers based off the position of the imu given earlier.

        // Turning is kept the same, as its the same movement no matter the heading
        // Check if the imu was specified
        if (imu != null)
        {
            double calculatedForwardPower, calculatedStrafePower;

            calculatedForwardPower = forwardPower * Math.cos(heading)
                    + strafePower * Math.sin(heading);
            calculatedStrafePower = -forwardPower * Math.sin(heading)
                    + strafePower * Math.cos(heading);
            powerDrive(calculatedForwardPower,calculatedStrafePower, turningPower);
        } else {
            powerDrive(0, 0, 0);
        }
    }

    /**
     * Drive at an angle.
     *
     * @param angle the angle in degrees
     */
    public void driveAngle(double angle)
    {
        angle -= 90;
        angle = -angle;

        double forward = -Math.sin(Math.toRadians(angle));
        double strafe = Math.cos(Math.toRadians(angle));

        powerDrive(forward, strafe, 0);
    }

    /**
     * Drive at an angle in radians.
     *
     * @param angle the angle in radians
     */
    public void driveAngleRadians(double angle)
    {
        angle -= Math.toRadians(90);
        angle = -angle;
        double forward = -Math.sin(angle);
        double strafe = Math.cos(angle);

        powerDrive(forward, strafe, 0);
    }


    /**
     * Drive at an angle, with the a speed factor ranging 0 and 1.
     *
     * @param angle the angle in degrees
     * @param speed the speed (0-1)
     */
    public void driveAngle(double angle, double speed)
    {
        angle -= 90;
        angle = -angle;

        double forward = -Math.sin(Math.toRadians(angle));
        double strafe = Math.cos(Math.toRadians(angle));
        forward = forward * speed;
        strafe = strafe * speed;


        powerDrive(forward, strafe, 0);
    }


    /**
     * Drive at an angle in radians, with a speed factor ranging from 0 and 1.
     *
     * @param angle the angle in radians
     * @param speed the speed (0-1)
     */
    public void driveAngleRadians(double angle, double speed)
    {
        angle -= Math.toRadians(90);
        angle = -angle;
        double forward = -Math.sin(angle);
        double strafe = Math.cos(angle);
        forward = forward * speed;
        strafe = strafe * speed;

        powerDrive(forward, strafe, 0);
    }


    /**
     * Stop.
     */
    public void stop()
    {
        powerDrive(0, 0, 0);
    }
}
