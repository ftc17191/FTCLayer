package org.ftc17191.ftclayer.hardware.servos.servoex;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * The type Servo ex.
 */
public class ServoEx
{
    /**
     * The Servo.
     */
    public Servo servo;
    /**
     * The Minimum degrees.
     */
    int minimum_degrees = 0;
    /**
     * The Maximum degrees.
     */
    int maximum_degrees = 0;

    /**
     * Instantiates a new Servo ex.
     *
     * @param hardwareMap the hardware map
     * @param id          the id
     */
    public ServoEx(@NonNull HardwareMap hardwareMap, @NonNull String id)
    {
        servo = hardwareMap.get(Servo.class, id);
    }

    /**
     * Instantiates a new Servo ex.
     *
     * @param hardwareMap     the hardware map
     * @param id              the id
     * @param minimum_degrees the minimum degrees
     * @param maximum_degrees the maximum degrees
     */
    public ServoEx(@NonNull HardwareMap hardwareMap, @NonNull String id, int minimum_degrees, int maximum_degrees)
    {
        servo = hardwareMap.get(Servo.class, id);
        this.minimum_degrees = minimum_degrees;
        this.maximum_degrees = maximum_degrees;
    }

    /**
     * Sets minimum degrees.
     *
     * @param minimum_degrees the minimum degrees
     */
    public void setMinimumDegrees(int minimum_degrees) {
        this.minimum_degrees = minimum_degrees;
    }

    /**
     * Sets maximum degrees.
     *
     * @param maximum_degrees the maximum degrees
     */
    public void setMaximumDegrees(int maximum_degrees) {
        this.maximum_degrees = maximum_degrees;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(double position)
    {
        servo.setPosition(position);
    }

    /**
     * Sets position degrees (requires the minimum / maximum degrees to be set).
     *
     * @param degrees the degrees
     */
    public void setPositionDegrees(double degrees)
    {
        servo.setPosition(degrees / (maximum_degrees - minimum_degrees));
    }
}
