package org.ftc17191.ftclayer.hardware.revhub;

import org.ftc17191.ftclayer.hardware.motors.MotorEx;
import org.ftc17191.ftclayer.hardware.motors.motorinfo.MotorInfo;


/*
 * This class is supposed to be a place holder for IDS, so instead of
 *      motor = new DcMotor("motor4 or whatever");
 * with RevHub its
 *      motor = new DcMotor(hub.motor_id[0]);
 * it may be less cleaner in certain scenarios but it'll prevent bugs when changing ids.
 */

public class  RevHub
{
    // Ids and info
    public String motor_id[] = new String[3];
    public MotorInfo motor_info[] = new MotorInfo[3];
    public String servo_ids[]  = new String[4];
    public String i2c_ids[]  = new String[3];
}
