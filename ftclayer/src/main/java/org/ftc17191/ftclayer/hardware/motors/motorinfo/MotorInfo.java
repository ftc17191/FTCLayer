package org.ftc17191.ftclayer.hardware.motors.motorinfo;

/* Right so we need a couple things
1. Motor name
2. Encoder info (tick per rotation, maximum rpm)
3. Torque (kg/cm)

This class is a replacement for a struct since java doesn't have those.
 */

/**
 * The type Motor info.
 */
public class MotorInfo {
    private final String name;
    private final double torqueKgCm;
    private final Float encoderTicksPerRotation;
    private final int rpm;

    /**
     * Instantiates a new Motor info.
     *
     * @param motorName          the motor name
     * @param torque             the torque
     * @param ticksPerRotation   the ticks per rotation
     * @param rotationsPerMinute the rotations per minute
     */
    public MotorInfo(String motorName, double torque,
                     Float ticksPerRotation, int rotationsPerMinute) {
        name = motorName;
        torqueKgCm = torque;
        encoderTicksPerRotation = ticksPerRotation;
        rpm = rotationsPerMinute;
    }

    /**
     * Instantiates a new Motor info.
     *
     * @param torque             the torque
     * @param ticksPerRotation   the ticks per rotation
     * @param rotationsPerMinute the rotations per minute
     */
    public MotorInfo(double torque,
                     Float ticksPerRotation, int rotationsPerMinute) {
        name = null;
        torqueKgCm = torque;
        encoderTicksPerRotation = ticksPerRotation;
        rpm = rotationsPerMinute;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
// Getter Functions
    public String getName() {
        return name;
    }

    /**
     * Gets torque in kg / cm.
     *
     * @return the torque kg cm
     */
    public double getTorqueKgCm() {
        return torqueKgCm;
    }

    /**
     * Gets maximum rpm.
     *
     * @return the rpm
     */
    public int getRpm() {
        return rpm;
    }

    /**
     * Gets encoder ticks per rotation.
     *
     * @return the encoder ticks per rotation
     */
    public Float getEncoderTicksPerRotation() {
        return encoderTicksPerRotation;
    }

}
