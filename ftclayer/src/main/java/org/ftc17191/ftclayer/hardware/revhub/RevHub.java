package org.ftc17191.ftclayer.hardware.revhub;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;
import org.ftc17191.ftclayer.hardware.servos.servoex.ServoEx;


/*
 * This class is supposed to be a place holder for IDS, so instead of
 *      motor = new DcMotor("motor4 or whatever");
 * with RevHub its
 *      motor = new DcMotor(hub.motor_id[0]);
 * it may be less cleaner in certain scenarios but it'll prevent bugs when changing ids.
 */

public class RevHub {
    // Ids and hardware map
    public HardwareMap hardwareMap;
    public String motorIds[] = new String[4];
    public String servoIds[] = new String[6];
    public String i2CIds[] = new String[4];
    public MotorEx motor[] = new MotorEx[4];
    public ServoEx servo[] = new ServoEx[6];

    public RevHub(RevHubParameters parameters)
    {
        hardwareMap = parameters.hardwareMap;
        motorIds = parameters.motor;
        servoIds = parameters.servo;
        i2CIds = parameters.i2c;

        for (int i = 0; i < motorIds.length; i++)
        {
            if (motorIds[i] != null && motorIds[i].length() != 0)
            {
                motor[i] = new MotorEx(hardwareMap, motorIds[i]);
            }
        }

        for (int i = 0; i < servoIds.length; i++)
        {
            if (servoIds[i] != null && servoIds[i].length() != 0)
            {
                servo[i] = new ServoEx(hardwareMap, servoIds[i]);
            }
        }
    }



}
