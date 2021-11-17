package org.ftc17191.ftclayer.hardware.motors.motorinfo;

/* Right so we need a couple things
1. Motor name
2. Encoder info (tick per rotation, maximum rpm)
3. Torque (kg/cm)

This class is a replacement for a struct since java doesn't have those.
 */

public class MotorInfo
{
    private String name;
    private double torque_kg_cm;
    private double encoder_ticks_per_rotation;
    private int rpm;

    // Constructors
    public MotorInfo(String motor_name, double torque,
                     Float ticks_per_rotation, int rotations_per_minute)
    {
        name = motor_name;
        torque_kg_cm = torque;
        encoder_ticks_per_rotation = ticks_per_rotation;
        rpm = rotations_per_minute;
    }

    public MotorInfo(double torque,
                     double ticks_per_rotation, int rotations_per_minute)
    {
        name = null;
        torque_kg_cm = torque;
        encoder_ticks_per_rotation = ticks_per_rotation;
        rpm = rotations_per_minute;
    }

    // Getter Functions
    public String getName() {
        return name;
    }

    public double getTorque_kg_cm() {
        return torque_kg_cm;
    }

    public int getRpm() {
        return rpm;
    }

    public double getEncoder_ticks_per_rotation() {
        return encoder_ticks_per_rotation;
    }

}
