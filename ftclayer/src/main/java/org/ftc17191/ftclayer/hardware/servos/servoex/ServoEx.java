package org.ftc17191.ftclayer.hardware.servos.servoex;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoEx
{
    public Servo servo;
    int minimum_degrees = 0;
    int maximum_degrees = 0;

    public ServoEx(@NonNull HardwareMap hardwareMap, @NonNull String id)
    {
        servo = hardwareMap.get(Servo.class, id);
    }
    public ServoEx(@NonNull HardwareMap hardwareMap, @NonNull String id, int minimum_degrees, int maximum_degrees)
    {
        servo = hardwareMap.get(Servo.class, id);
        this.minimum_degrees = minimum_degrees;
        this.maximum_degrees = maximum_degrees;
    }

    public void setMinimumDegrees(int minimum_degrees) {
        this.minimum_degrees = minimum_degrees;
    }

    public void setMaximumDegrees(int maximum_degrees) {
        this.maximum_degrees = maximum_degrees;
    }

    public void setPosition(double position)
    {
        servo.setPosition(position);
    }

    public void setPositionDegrees(double degrees)
    {
        servo.setPosition(degrees / (maximum_degrees - minimum_degrees));
    }
}
