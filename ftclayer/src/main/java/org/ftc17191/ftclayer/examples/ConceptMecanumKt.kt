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



package org.ftc17191.examples

import com.qualcomm.robotcore.eventloop.opmode.*
import org.ftc17191.ftclayer.drivetrain.mecanum.Mecanum



@TeleOp(name = "Concept Mecanum", group = "Concept")
@Disabled // Remove this Line if using as an opmode
class ConceptMecanumKt : OpMode()
{
    lateinit var train: Mecanum

    override fun init()
    {
        train = Mecanum(hardwareMap,
                "fr_motor",
                "fl_motor",
                "br_motor",
                "bl_motor")
        telemetry.addLine("Press Start to begin!")
        telemetry.update()
    }

    override fun loop()
    {
        train.powerDrive(gamepad1.left_stick_y.toDouble(), gamepad1.left_stick_x.toDouble(), gamepad1.right_stick_x.toDouble())

        telemetry.addLine("Fr Motor Power: " + train.fr_motor.motor.power)
        telemetry.addLine("Fl Motor Power: " + train.fl_motor.motor.power)
        telemetry.addLine("Br Motor Power: " + train.br_motor.motor.power)
        telemetry.addLine("Bl Motor Power: " + train.bl_motor.motor.power)
        telemetry.update()
    }
}