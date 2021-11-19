package org.ftc17191.ftclayer.hardware.revhub;

import com.qualcomm.robotcore.hardware.HardwareMap;
import java.lang.IndexOutOfBoundsException;

import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;
import org.ftc17191.ftclayer.hardware.motors.motorinfo.MotorInfo;


/*
 * This class is supposed to be a place holder for IDS, so instead of
 *      motor = new DcMotor("motor4 or whatever");
 * with RevHub its
 *      motor = new DcMotor(hub.motor_id[0]);
 * it may be less cleaner in certain scenarios but it'll prevent bugs when changing ids.
 */

public class RevHub
{
    // Ids and hardware map
    private HardwareMap hardwareMap;
    private String motorIds[];
    private String servoIds[];
    private String i2cIds[];

    // Exceptions for random stuff
    public Exception NoHardwareMapSetException;
    public Exception NoPortIdSetException;

    // Enum for telling motor i2c and servos apart

    public enum PORT
    {
        MOTOR, SERVO, I2C
    }

    // Apply NULL if no motor or servo is on the port.
    // This constructor is terrible and inefficient but its good to make stuff easier for newbs
    RevHub(HardwareMap hardwareMap,
           String motor0,
           String motor1,
           String motor2,
           String motor3,
           String servo0,
           String servo1,
           String servo2,
           String servo3,
           String servo4,
           String servo5,
           String i2c0,
           String i2c1,
           String i2c2,
           String i2c3)
    {
        // Initialize arrays and hardware map
        this.hardwareMap = hardwareMap;

        motorIds = new String[4];
        servoIds = new String[6];
        i2cIds = new String[4];

        // This is terrible
        motorIds[0] = motor0;
        motorIds[1] = motor1;
        motorIds[2] = motor2;
        motorIds[3] = motor3;
        servoIds[0] = servo0;
        servoIds[1] = servo1;
        servoIds[2] = servo2;
        servoIds[3] = servo3;
        servoIds[4] = servo4;
        servoIds[5] = servo5;
        i2cIds[0] = i2c0;
        i2cIds[1] = i2c1;
        i2cIds[2] = i2c2;
        i2cIds[3] = i2c3;
    }

    // Same thing as above, just without hardware
    RevHub(String motor0,
           String motor1,
           String motor2,
           String motor3,
           String servo0,
           String servo1,
           String servo2,
           String servo3,
           String servo4,
           String servo5,
           String i2c0,
           String i2c1,
           String i2c2,
           String i2c3)
    {
        // Initialize arrays
        motorIds = new String[4];
        servoIds = new String[6];
        i2cIds = new String[4];

        // This is terrible
        motorIds[0] = motor0;
        motorIds[1] = motor1;
        motorIds[2] = motor2;
        motorIds[3] = motor3;
        servoIds[0] = servo0;
        servoIds[1] = servo1;
        servoIds[2] = servo2;
        servoIds[3] = servo3;
        servoIds[4] = servo4;
        servoIds[5] = servo5;
        i2cIds[0] = i2c0;
        i2cIds[1] = i2c1;
        i2cIds[2] = i2c2;
        i2cIds[3] = i2c3;
    }


    // Take in arrays instead of.... up there
    RevHub(HardwareMap hardwareMap,
           String motorIds[],
           String servoIds[],
           String i2cIds[]) throws Exception
    {
        // Check if index on array is out of bounds, they must include null on not included motors
        if (motorIds.length == 4 && servoIds.length == 6 && i2cIds.length == 4) {
            this.motorIds = motorIds;
            this.servoIds = servoIds;
            this.i2cIds = i2cIds;
            this.hardwareMap = hardwareMap;
        } else {
            throw new IndexOutOfBoundsException("Index on RevHub out of bounds.");
        }
    }


    // Same thing but without hardware map
    RevHub(String motorids[],
           String servoids[],
           String i2cids[]) throws Exception
    {
        // Check if index on array is out of bounds, they must include null on not included motors
        if (motorids.length == 4 && servoids.length == 6 && i2cids.length == 4) {
            motorIds = motorids;
            servoIds = servoids;
            i2cIds = i2cids;
        } else {
            throw new IndexOutOfBoundsException("Index on RevHub out of bounds.");
        }
    }

    /**************
     *  Getters and setters
     *************/

    public String getMotorId(int port)
    {
        if (port <= 3 && port >= 0)
        {
            return motorIds[port];
        } else {
            throw new IndexOutOfBoundsException("Parameter 'port' is either too big or small.");
        }
    }

    public String getServoId(int port)
    {
        if (port <= 5 && port >= 0)
        {
            return servoIds[port];
        } else {
            throw new IndexOutOfBoundsException("Parameter 'port' is either too big or small.");
        }
    }

    public String getI2CId(int port)
    {
        if (port <= 3 && port >= 0)
        {
            return i2cIds[port];
        } else {
            throw new IndexOutOfBoundsException("Parameter 'port' is either too big or small.");
        }
    }

    public void setHardwareMap(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }


}
