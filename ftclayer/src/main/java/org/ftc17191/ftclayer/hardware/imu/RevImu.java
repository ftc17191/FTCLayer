package org.ftc17191.ftclayer.hardware.imu;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

// Thanks to FTC Lib,
// We used FTC Lib's IMU class and the ConceptBNO015IMU as a reference when making this one.


/**
 * The type Rev imu.
 */
public class RevImu {

    public enum ROTATIONAL_DIRECTIONS {
        PITCH, HEADING, ROLL
    }

    /**
     * The Imu.
     */
    public BNO055IMU imu;
    private double headingOffset = 0;
    private double pitchOffset = 0;
    private double rollOffset = 0;


    /**
     * Instantiates a new Rev imu.
     *
     * @param hardwareMap the hardware map
     * @param id          the id
     */
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

    /**
     * Gets heading.
     *
     * @return the heading
     */
    public double getHeading() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).firstAngle - headingOffset;
    }

    /**
     * Gets heading in radians.
     *
     * @return the heading radians
     */
    public double getHeadingRadians() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).firstAngle - Math.toRadians(headingOffset);
    }

    /**
     * Gets absolute heading.
     *
     * @return the absolute heading
     */
    public double getAbsoluteHeading() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).firstAngle;
    }

    /**
     * Gets absolute heading in radians.
     *
     * @return the absolute heading radians
     */
    public double getAbsoluteHeadingRadians() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).firstAngle;
    }

    /**
     * Gets pitch.
     *
     * @return the pitch
     */
    public double getPitch() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).secondAngle - pitchOffset;
    }

    /**
     * Gets pitch in radians.
     *
     * @return the pitch radians
     */
    public double getPitchRadians() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).secondAngle - Math.toRadians(pitchOffset);
    }

    /**
     * Gets absolute pitch.
     *
     * @return the absolute pitch
     */
    public double getAbsolutePitch() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).secondAngle;
    }

    /**
     * Gets absolute pitch in radians.
     *
     * @return the absolute pitch radians
     */
    public double getAbsolutePitchRadians() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).secondAngle ;
    }

    /**
     * Gets roll.
     *
     * @return the roll
     */
    public double getRoll() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle - rollOffset;
    }

    /**
     * Gets roll in radians.
     *
     * @return the roll radians
     */
    public double getRollRadians() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).thirdAngle - Math.toRadians(rollOffset);
    }

    /**
     * Gets absolute roll.
     *
     * @return the absolute roll
     */
    public double getAbsoluteRoll() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle;
    }

    /**
     * Gets absolute roll in radians.
     *
     * @return the absolute roll radians
     */
    public double getAbsoluteRollRadians() {
        return imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.RADIANS).thirdAngle;
    }


    /**
     * Reset position. Essentially calibration.
     */
    public void reset()
    {
        headingOffset = getAbsoluteHeading();
        pitchOffset = getAbsolutePitch();
        rollOffset = getAbsoluteRoll();
    }
}
