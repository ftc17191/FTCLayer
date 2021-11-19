package org.ftc17191.ftclayer.drivetrain.tank;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;


@Disabled
public class FourWheeledTank
{
    // Motors
    public MotorEx fr_motor;
    public MotorEx fl_motor;
    public MotorEx br_motor;
    public MotorEx bl_motor;


    // Takes in 4 ids and hardware map, makes MotorEx's based on ids.
    public FourWheeledTank(HardwareMap hmap,
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


    // Makes MotorEx's based on already existing DcMotors
    public FourWheeledTank(
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


    // Sets motor runmode
    private void setRunMode(DcMotor.RunMode mode)
    {
        fr_motor.motor.setMode(mode);
        fl_motor.motor.setMode(mode);
        br_motor.motor.setMode(mode);
        bl_motor.motor.setMode(mode);
    }


    // Drives based on 2 power statements
    public void powerDrive(double right_power, double left_power)
    {
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fr_motor.motor.setPower(right_power);
        fl_motor.motor.setPower(left_power);
        br_motor.motor.setPower(right_power);
        bl_motor.motor.setPower(left_power);
    }
}
