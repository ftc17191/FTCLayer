package org.ftc17191.ftclayer.kgmotion;

import org.ftc17191.ftclayer.drivetrain.mecanum.Mecanum;
import org.ftc17191.ftclayer.kgmotion.localization.LocalizationMethod;
import org.ftc17191.ftclayer.kgmotion.motion.Coordinate;
import org.ftc17191.ftclayer.kgmotion.motion.Position;


public class Robot
{
    // Massive props to CTRL-ALT-FTC,w I have no clue how to do control systems, and that's the site that saved me
    public Mecanum drivetrain;
    public LocalizationMethod localization;
    private Coordinate targetCoordinate;
    private double targetAngle;
    public double acceptance = .3;
    public double momentumAcceptance = 1;
    public double kp = .5;
    public double ki = 0;
    public double kd = 0;
    public double turningAcceptance = .5;
    public double turningKp = .1; // Since error is in degrees, we're gonna have it pretty low
    public double turningKi = 0;
    public double turningKd = 0;
    private double startTime;
    private double ix;
    private double iy;
    private double lastXError;
    private double lastYError;
    private boolean active = false;



    // Time stuff for integral and derivative
    public Robot(Mecanum drivetrain, LocalizationMethod localization)
    {
        this.drivetrain = drivetrain;
        this.localization = localization;
        this.drivetrain.stop();
    }

    public void setTarget(Coordinate coordinate)
    {
        targetCoordinate = coordinate;
    }

    public void goToTarget()
    {
        active = true;
        startTime = System.currentTimeMillis();

        double xDif = targetCoordinate.x - localization.getPosition().x;
        double yDif = targetCoordinate.y - localization.getPosition().y;

        targetAngle = Math.atan2(yDif, xDif);
    }

    public void goToTarget(Coordinate coordinate)
    {
        setTarget(coordinate);
        goToTarget();
    }

    public void update()
    {
        // Updates that don't need to happen
        if (!active)
        {
            return;
        }

        // Get Position
        Position currentPosition = localization.getPosition();
        currentPosition.rotation += 90; //
        double time = (System.currentTimeMillis() - startTime) / 1000;



        // Check if we are there
        if ((currentPosition.x >= targetCoordinate.x - acceptance && currentPosition.x <= targetCoordinate.x + acceptance) &&
                (currentPosition.y >= targetCoordinate.y - acceptance && currentPosition.y <= targetCoordinate.y + acceptance)) {

            active = false;
            drivetrain.stop();
        } else {
            // Error
            double xError = targetCoordinate.x - currentPosition.x;
            double yError = targetCoordinate.y - currentPosition.y;

            double hypotenuse = Math.sqrt((xError * xError) + (yError * yError));

            // For hypotenuse, we can just use the offset

            // For perpendicular offset, we are gonna calc where we are supposed to be according to hyp, and we actually are.


            // Integral
            // Calculus class is hard. Calculus in programming is easy (most of the time).
            ix += xError * time;
            iy += yError * time;

            // Derivative
            double dx = (xError - lastXError) / time;
            double dy = (yError - lastYError) / time;

            // Power for perp offset
            double powerX = (xError * kp) + (ix * ki) + (dx * kd);
            // Power for the hypotenuse
            double powerY = (yError * kp) + (iy * ki) + (dy * kd);



            // Set speed
            // Since position's angle isn't relative to the starting angle, and towards the y-axis, we can just use the absolute function
            drivetrain.powerAbsoluteDrive(powerY, -powerX, 0, currentPosition.rotation);


            lastXError = xError;
            lastYError = yError;
        }
        // A wise soccer coach once told me: "Java is as hard and complex as C, with none of the advantages of C."
    }

    public void turnTo(int degrees) {
        while ((degrees - localization.getPosition().rotation) < degrees - acceptance  || (degrees - localization.getPosition().rotation) > degrees + acceptance)
        {
            drivetrain.powerDrive(0, 0,(degrees - localization.getPosition().rotation) * kp);
        }
        drivetrain.stop();
    }

    public boolean running()
    {
        return active;
    }

}
