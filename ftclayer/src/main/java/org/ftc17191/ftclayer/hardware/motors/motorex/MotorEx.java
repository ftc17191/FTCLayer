package org.ftc17191.ftclayer.hardware.motors.motorex;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorinfo.MotorInfo;


// A more advanced DcMotorEx
public class MotorEx {
    public DcMotorEx motor;
    private MotorInfo motor_info;
    public Exception NoMotorInfoSetException;

    /***********
     *
     * Constructors
     *
     ***********/



    // Get motor, then set it
    public MotorEx(@NonNull HardwareMap map, @NonNull String id)
    {
        motor = map.get(DcMotorEx.class, id);
    }

    // Get motor and motorinfo, then set it
    public MotorEx(@NonNull HardwareMap map, @NonNull String id, @NonNull MotorInfo minfo)
    {
        motor = map.get(DcMotorEx.class, id);
        motor_info = minfo;
    }

    // Just set the motor
    public MotorEx(@NonNull DcMotorEx dcmotor)
    {
        motor = dcmotor;
    }

    // Just set the motor and Info
    public MotorEx(@NonNull DcMotorEx dcmotor, MotorInfo minfo)
    {
        motor = dcmotor;
        motor_info = minfo;
    }

    /***********
     *
     * Run Mode
     *
     ***********/

    // Checks if already set instead of calling the sdk which takes about 50 ms.
    public void setMotorRunMode(DcMotor.RunMode mode)
    {
        if (motor.getMode() != mode)
        {
            motor.setMode(mode);
        }
    }

    /***********
     *
     * Power Based Functions
     *
     ***********/

    /***********
     *
     * Velocity Based Functions
     *
     ***********/

    // Gets rpm then calculates it using MotorInfo class provided earlier
    public void setMotorVelocityRPM (double rpm) throws Exception {
        setMotorRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if (motor_info == null) {
            throw NoMotorInfoSetException;
        } else {
            // Take tpr, multiply by rotations needed in a minute, since setVelocity uses seconds
            // divide by 60 to make it seconds
            motor.setVelocity(motor_info.getEncoder_ticks_per_rotation() * rpm / 60);
        }
    }


    // Gets rpm then calculates it using MotorInfo class
    public void setMotorVelocityRPM(double rpm, MotorInfo motorinfo)
    {
        setMotorRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Take tpr, multiply by rotations needed in a minute, since setVelocity uses seconds
        // divide by 60 to make it seconds
        motor.setVelocity((motorinfo.getEncoder_ticks_per_rotation() * rpm ) / 60);
    }

    // Sets Ticks per Minute
    public void setMotorVelocityTPM(double tpm)
    {
        setMotorRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setVelocity(tpm / 60);
    }




    // checks runmoide like above
    public void setMotorPower(double power)
    {
        setMotorRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setPower(power);
    }
}


