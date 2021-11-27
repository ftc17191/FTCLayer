/*
 *
 *
 * This opmode simply moves a mechanum drivetrain.
 *
 * To use this opmode, move the file to the team code folder.
 * then follow the instructions through out the file
 *
 *
 */


package org.ftc17191.ftclayer.examples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.ftc17191.ftclayer.drivetrain.mecanum.Mecanum;


@TeleOp(name = "Concept Mecanum", group = "Concept")
@Disabled // Remove this Line if using as an opmode
public class ConceptMecanum extends OpMode {
    Mecanum train;

    @Override
    public void init() {
        train = new Mecanum(hardwareMap,
                "frontRightMotor",
                "frontLeftMotor",
                "backRightMotor",
                "backLeftMotor");

        telemetry.addLine("Press Start to begin!");
        telemetry.update();
    }

    @Override
    public void loop() {
        train.powerDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        telemetry.addLine("Fr Motor Power: " + train.frontRightMotor.dcMotor.getPower());
        telemetry.addLine("Fl Motor Power: " + train.frontLeftMotor.dcMotor.getPower());
        telemetry.addLine("Br Motor Power: " + train.backRightMotor.dcMotor.getPower());
        telemetry.addLine("Bl Motor Power: " + train.backLeftMotor.dcMotor.getPower());
        telemetry.update();
    }

}
