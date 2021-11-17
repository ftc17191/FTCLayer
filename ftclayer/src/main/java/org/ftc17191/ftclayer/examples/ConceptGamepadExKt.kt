package org.ftc17191.examples

import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.robotcore.internal.ui.GamepadUser
import org.ftc17191.ftclayer.gamepad.GamepadButtons
import org.ftc17191.ftclayer.gamepad.GamepadEx


@TeleOp(name = "Concept GamepadEx", group = "Concept")
@Disabled // Remove this Line if using as an opmode
class ConceptGamepadExKt : OpMode() {
    var gpad = GamepadEx(GamepadUser.ONE)

    override fun init() {
        telemetry.addLine("Press Start to begin!")
        telemetry.update()
    }

    override fun loop() {
        telemetry.addLine("Is a pressed?")

        // The ? and the : means "If the button is activated, say 'yes' if not, say 'no'. "
        telemetry.addLine(if (gpad.isButtonActivated(GamepadButtons.GamepadDigital.A)) "Yes it is!" else "Nope, press A")
    }
}