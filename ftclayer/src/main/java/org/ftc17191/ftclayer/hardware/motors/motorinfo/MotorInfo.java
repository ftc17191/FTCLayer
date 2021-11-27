package org.ftc17191.ftclayer.hardware.motors.motorinfo;

/* Right so we need a couple things
1. Motor name
2. Encoder info (tick per rotation, maximum rpm)
3. Torque (kg/cm)

This class is a replacement for a struct since java doesn't have those.
 */

public class MotorInfo {
    private final String name;
    private final double torqueKgCm;
    private final Float encoderTicksPerRotation;
    private final int rpm;

    // Constructors
    public MotorInfo(String motorName, double torque,
                     Float ticksPerRotation, int rotationsPerMinute) {
        name = motorName;
        torqueKgCm = torque;
        encoderTicksPerRotation = ticksPerRotation;
        rpm = rotationsPerMinute;
    }

    public MotorInfo(double torque,
                     Float ticksPerRotation, int rotationsPerMinute) {
        name = null;
        torqueKgCm = torque;
        encoderTicksPerRotation = ticksPerRotation;
        rpm = rotationsPerMinute;
    }

    // Getter Functions
    public String getName() {
        return name;
    }

    public double getTorqueKgCm() {
        return torqueKgCm;
    }

    public int getRpm() {
        return rpm;
    }

    public Float getEncoderTicksPerRotation() {
        return encoderTicksPerRotation;
    }

}
