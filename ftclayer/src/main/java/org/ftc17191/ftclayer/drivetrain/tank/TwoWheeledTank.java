package org.ftc17191.ftclayer.drivetrain.tank;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;

public class TwoWheeledTank
{
    public MotorEx r_motor;
    public MotorEx l_motor;

    TwoWheeledTank(HardwareMap hmap,
                   String right_motor,
                   String left_motor)
    {
        r_motor = new MotorEx(hmap, right_motor);
        l_motor = new MotorEx(hmap, left_motor);
    }

    // Makes MotorEx's based on already existing DcMotors
    public TwoWheeledTank(DcMotorEx right_motor,
                          DcMotorEx left_motor)
    {
        r_motor = new MotorEx(right_motor);
        l_motor = new MotorEx(left_motor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    // Sets motor runmode
    private void setRunMode(DcMotor.RunMode mode)
    {
        r_motor.motor.setMode(mode);
        l_motor.motor.setMode(mode);
    }


    // Drives based on 2 power statements
    public void powerDrive(double right_power, double left_power)
    {
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        r_motor.motor.setPower(right_power);
        l_motor.motor.setPower(left_power);

    }
}
