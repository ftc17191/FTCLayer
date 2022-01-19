package org.ftc17191.ftclayer.hardware.motors.motorex;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorinfo.MotorInfo;


// A more advanced DcMotorEx
public class MotorEx {
    public DcMotorEx dcMotor;
    public Exception NoMotorInfoSetException;
    private MotorInfo motorInfo;

    /***********
     *
     * Constructors
     *
     ***********/

    // Get dcMotor, then set it
    public MotorEx(@NonNull HardwareMap hardwareMap, @NonNull String id) {
        dcMotor = hardwareMap.get(DcMotorEx.class, id);
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    // Get dcMotor and motorinfo, then set it
    public MotorEx(@NonNull HardwareMap hardwareMap, @NonNull String id, @NonNull MotorInfo motorInfo) {
        dcMotor = hardwareMap.get(DcMotorEx.class, id);
        this.motorInfo = motorInfo;
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    // Just set the dcMotor
    public MotorEx(@NonNull DcMotorEx dcMotor) {
        this.dcMotor = dcMotor;
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    // Just set the dcMotor and Info
    public MotorEx(@NonNull DcMotorEx dcMotor, MotorInfo motorInfo) {
        this.dcMotor = dcMotor;
        this.motorInfo = motorInfo;
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    /***********
     *
     * Run Mode
     *
     ***********/

    // Checks if already set instead of calling the sdk which takes about 50 ms.
    public void setMode(DcMotor.RunMode mode) {
        if (dcMotor.getMode() != mode) {
            dcMotor.setMode(mode);
        }
    }

    /***********
     *
     * Power Based Functions
     *
     ***********/

    public void setPower(double power)
    {
        setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dcMotor.setPower(power);
    }

    /***********
     *
     * Position Based Functions
     *
     ***********/

    public void goToPosition(int ticks) {
        dcMotor.setTargetPosition(ticks);
        setMode(DcMotor.RunMode.RUN_TO_POSITION);
        dcMotor.setPower(1); // Dunno velocity. We're gonna go with.. this number I guess.
        // Should give the motors max velocity

        // Wait till we're done
        while (dcMotor.isBusy()) {}

        dcMotor.setPower(0);

    }


    /***********
     *
     * Velocity Based Functions
     *
     ***********/

    // Gets rpm then calculates it using MotorInfo class provided earlier
    public void setMotorVelocityRPM(double rpm) throws Exception {
        setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if (motorInfo == null) {
            throw NoMotorInfoSetException;
        } else {
            // Take tpr, multiply by rotations needed in a minute, since setVelocity uses seconds
            // divide by 60 to make it seconds
            dcMotor.setVelocity(motorInfo.getEncoderTicksPerRotation() * rpm / 60);
        }
    }


    // Gets rpm then calculates it using MotorInfo class
    public void setMotorVelocityRPM(double rpm, MotorInfo motorInfo) {
        setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Take tpr, multiply by rotations needed in a minute, since setVelocity uses seconds
        // divide by 60 to make it seconds
        dcMotor.setVelocity((motorInfo.getEncoderTicksPerRotation() * rpm) / 60);
    }

    // Sets Ticks per Minute
    public void setMotorVelocityTPM(double tpm) {
        setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Velocity uses Ticks per second so divide by 60
        dcMotor.setVelocity(tpm / 60);
    }


    // checks run mode like above
    public void setMotorPower(double power) {
        setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dcMotor.setPower(power);
    }
}


