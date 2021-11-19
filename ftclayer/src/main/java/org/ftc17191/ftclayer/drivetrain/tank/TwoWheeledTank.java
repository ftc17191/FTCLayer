package org.ftc17191.ftclayer.drivetrain.tank;

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


}
