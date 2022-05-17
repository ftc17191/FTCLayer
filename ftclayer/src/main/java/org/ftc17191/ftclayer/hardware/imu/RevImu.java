package org.ftc17191.ftclayer.hardware.imu;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

// Thanks to FTC Lib,
// We used FTC Lib's IMU class and the ConceptBNO015IMU as a reference when making this one.


public class RevImu {

    public BNO055IMU imu;
    private double headingOffset = 0;
    private double pitchOffset = 0;
    private double rollOffset = 0;


    public RevImu(HardwareMap hardwareMap, String id) {
        imu = hardwareMap.get(BNO055IMU.class, id);

        BNO055IMU.Parameters param = new BNO055IMU.Parameters();
        param.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        param.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        param.calibrationDataFile = "BNO055IMUCalibration.json";
        param.loggingEnabled = true;
        param.loggingTag = "FTCLayer IMU";
        param.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu.initialize(param);
    }

    public double getHeading() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).firstAngle - headingOffset;
    }

    public double getHeadingRadians() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).firstAngle - Math.toRadians(headingOffset);
    }

    public double getPitch() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).secondAngle - pitchOffset;
    }

    public double getPitchRadians() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).secondAngle - Math.toRadians(pitchOffset);
    }

    public double getRoll() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle - rollOffset;
    }

    public double getRollRadians() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).thirdAngle - Math.toRadians(rollOffset);
    }


    public void reset()
    {
        headingOffset = getHeading();
        pitchOffset = getPitch();
        rollOffset = getRoll();
    }
}
