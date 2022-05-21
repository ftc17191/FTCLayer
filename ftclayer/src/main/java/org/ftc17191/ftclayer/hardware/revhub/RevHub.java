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

/**
 * The type Rev hub.
 */
public class RevHub {
    /**
     * The Hardware map.
     */
    public HardwareMap hardwareMap;
    /**
     * The Motor ids.
     */
    public String motor_ids[] = new String[4];
    /**
     * The Servo ids.
     */
    public String servo_ids[] = new String[6];
    /**
     * The 2 c ids.
     */
    public String i2c_ids[] = new String[4];
    /**
     * The Motor.
     */
    public MotorEx motor[] = new MotorEx[4];
    /**
     * The Servo.
     */
    public ServoEx servo[] = new ServoEx[6];

    /**
     * Instantiates a new Rev hub.
     *
     * @param parameters the parameters
     */
    public RevHub(RevHubParameters parameters)
    {
        hardwareMap = parameters.hardwareMap;
        motor_ids = parameters.motor;
        servo_ids = parameters.servo;
        i2c_ids = parameters.i2c;

        for (int i = 0; i < motor_ids.length; i++)
        {
            if (motor_ids[i] != null && motor_ids[i].length() != 0)
            {
                motor[i] = new MotorEx(hardwareMap, motor_ids[i]);
            }
        }

        for (int i = 0; i < servo_ids.length; i++)
        {
            if (servo_ids[i] != null && servo_ids[i].length() != 0)
            {
                servo[i] = new ServoEx(hardwareMap, servo_ids[i]);
            }
        }
    }



}
