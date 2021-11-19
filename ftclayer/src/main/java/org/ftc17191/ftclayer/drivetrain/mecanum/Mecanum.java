package org.ftc17191.ftclayer.drivetrain.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;


@Disabled
public class Mecanum
{
    public MotorEx fr_motor;
    public MotorEx fl_motor;
    public MotorEx br_motor;
    public MotorEx bl_motor;

    public Mecanum(
            DcMotorEx front_right_motor,
            DcMotorEx front_left_motor,
            DcMotorEx back_right_motor,
            DcMotorEx back_left_motor)
    {
        fr_motor = new MotorEx(front_right_motor);
        fl_motor = new MotorEx(front_left_motor);
        br_motor = new MotorEx(back_right_motor);
        bl_motor = new MotorEx(back_left_motor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public Mecanum(
            HardwareMap hmap,
            String front_right_motor,
            String front_left_motor,
            String back_right_motor,
            String back_left_motor)
    {
        
        fr_motor = new MotorEx(hmap, front_right_motor);
        fl_motor = new MotorEx(hmap, front_left_motor);
        br_motor = new MotorEx(hmap, back_right_motor);
        bl_motor = new MotorEx(hmap, back_left_motor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    // Sets motor runmode
    private void setRunMode(DcMotor.RunMode mode)
    {
        fr_motor.motor.setMode(mode);
        fl_motor.motor.setMode(mode);
        br_motor.motor.setMode(mode);
        bl_motor.motor.setMode(mode);
    }


    public void powerDrive(double forwardPower, double strafePower, double turningPower)
    {
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fr_motor.motor.setPower(-forwardPower - strafePower - turningPower);
        fl_motor.motor.setPower(forwardPower - strafePower - turningPower);
        br_motor.motor.setPower(-forwardPower + strafePower - turningPower);
        bl_motor.motor.setPower(forwardPower + strafePower - turningPower);
    }

}
