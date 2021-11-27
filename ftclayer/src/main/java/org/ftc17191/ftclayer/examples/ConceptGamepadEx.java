package org.ftc17191.ftclayer.examples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.internal.ui.GamepadUser;
import org.ftc17191.ftclayer.gamepad.GamepadButtons;
import org.ftc17191.ftclayer.gamepad.GamepadEx;


@TeleOp(name = "Concept GamepadEx", group = "Concept")
@Disabled // Remove this Line if using as an opmode
public class ConceptGamepadEx extends OpMode {
    GamepadEx gamepadEx = new GamepadEx(GamepadUser.ONE);

    @Override
    public void init() {
        telemetry.addLine("Press Start to begin!");
        telemetry.update();
    }

    @Override
    public void loop() {
        telemetry.addLine("Is A pressed?");

        // The ? and the : means "If the button is activated, say 'yes' if not, say 'no'. "
        telemetry.addLine(gamepadEx.isButtonActivated(GamepadButtons.GamepadDigital.A)
                ? "Yes it is!" : "Nope, press A");

    }
}
