package org.ftc17191.ftclayer.hardware.imu;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

// Thanks to FTC Lib,
// We used FTC Lib's IMU class and the ConceptBNO015IMU as a reference when making this one.


public class RevImu {

    public BNO055IMU imu;

    public RevImu(HardwareMap hmap, String id)
    {
        imu = hmap.get(BNO055IMU.class, id);

        BNO055IMU.Parameters param = new BNO055IMU.Parameters();
        param.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        param.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        param.calibrationDataFile = "BNO055IMUCalibration.json";
        param.loggingEnabled = true;
        param.loggingTag = "FTCLayer IMU";
        param.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu.initialize(param);
    }

    public double getHeading()
    {
        return imu.getAngularOrientation().firstAngle;
    }

    public double getHeadingRadians()
    {
        return Math.toRadians(imu.getAngularOrientation().firstAngle);
    }

}
