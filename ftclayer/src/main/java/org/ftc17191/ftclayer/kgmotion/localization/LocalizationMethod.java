package org.ftc17191.ftclayer.kgmotion.localization;

import org.ftc17191.ftclayer.hardware.imu.RevImu;
import org.ftc17191.ftclayer.kgmotion.motion.Position;

public interface LocalizationMethod
{
    // No matter how you implement a localization method, You must return the coordinate of the center of the robot.
    public Position getPosition();
}
