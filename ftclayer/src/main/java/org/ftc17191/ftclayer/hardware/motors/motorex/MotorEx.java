package org.ftc17191.ftclayer.hardware.motors.motorex;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorinfo.MotorInfo;


/**
 * The type Motor ex.
 */
// A more advanced DcMotorEx
public class MotorEx {
    /**
     * The Dc motor.
     */
    public DcMotorEx dcMotor;
    /**
     * The No motor info set exception.
     */
    private MotorInfo motorInfo;

    /***********
     *
     * Constructors
     *
     * @param hardwareMap the hardware map
     * @param id the id
     */
    public MotorEx(@NonNull HardwareMap hardwareMap, @NonNull String id) {
        dcMotor = hardwareMap.get(DcMotorEx.class, id);
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    /**
     * Instantiates a new Motor ex.
     *
     * @param hardwareMap the hardware map
     * @param id          the id
     * @param motorInfo   the motor info
     */
    public MotorEx(@NonNull HardwareMap hardwareMap, @NonNull String id, @NonNull MotorInfo motorInfo) {
        dcMotor = hardwareMap.get(DcMotorEx.class, id);
        this.motorInfo = motorInfo;
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    /**
     * Instantiates a new Motor ex.
     *
     * @param dcMotor the dc motor
     */
    public MotorEx(@NonNull DcMotorEx dcMotor) {
        this.dcMotor = dcMotor;
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    /**
     * Instantiates a new Motor ex.
     *
     * @param dcMotor   the dc motor
     * @param motorInfo the motor info
     */
    public MotorEx(@NonNull DcMotorEx dcMotor, MotorInfo motorInfo) {
        this.dcMotor = dcMotor;
        this.motorInfo = motorInfo;
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    /***********
     *
     * Run Mode
     *
     * @param mode the mode
     */
    public void setMode(DcMotor.RunMode mode) {
        if (dcMotor.getMode() != mode) {
            dcMotor.setMode(mode);
        }
    }

    /***********
     *
     * Power Based Functions
     *
     * @param power the power
     */
    public void setPower(double power)
    {
        setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dcMotor.setPower(power);
    }

    /***********
     *
     * Position Based Functions
     *
     * @param ticks the ticks
     */
    public void goToPosition(int ticks) {
        dcMotor.setTargetPosition(ticks);
        setMode(DcMotor.RunMode.RUN_TO_POSITION);
        dcMotor.setPower(1);
        // Wait till we're done
        while (dcMotor.isBusy()) {}

        dcMotor.setPower(0);

    }


    /***********
     *
     * Set motor velocity in rotations per minute.  (requires motor info to be set)
     *
     * @param rpm the rpm
     */
    public void setMotorVelocityRPM(double rpm) {
        setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if (motorInfo == null) {
            dcMotor.setVelocity(0);
        } else {
            // Take tpr, multiply by rotations needed in a minute, since setVelocity uses seconds
            // divide by 60 to make it seconds
            dcMotor.setVelocity(motorInfo.getEncoderTicksPerRotation() * rpm / 60);
        }
    }


    /**
     * Sets motor velocity in rotation per minute.
     *
     * @param rpm       the rpm
     * @param motorInfo the motor info
     */
    public void setMotorVelocityRPM(double rpm, MotorInfo motorInfo) {
        setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Take tpr, multiply by rotations needed in a minute, since setVelocity uses seconds
        // divide by 60 to make it seconds
        dcMotor.setVelocity((motorInfo.getEncoderTicksPerRotation() * rpm) / 60);
    }

    /**
     * Sets motor velocity in ticks per minute. (requires motor info to be set)
     *
     * @param tpm the tpm
     */
    public void setMotorVelocityTPM(double tpm) {
        setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Velocity uses Ticks per second so divide by 60
        dcMotor.setVelocity(tpm / 60);
    }


    /**
     * Sets motor power.
     *
     * @param power the power
     */
    public void setMotorPower(double power) {
        setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dcMotor.setPower(power);
    }
}


