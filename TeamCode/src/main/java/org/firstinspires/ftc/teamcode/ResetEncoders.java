package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.robot.Robot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Reset Encoders", group = "Utilities")
public class ResetEncoders extends OpMode {

    basic_hardware robot;
    @Override
    public void init() {
        robot = new basic_hardware(this, false);
    }

    @Override
    public void loop() {
        telemetry.addData("LEFT Module Orientation: ", robot.driveController.moduleLeft.getCurrentOrientation().getAngle());
        telemetry.addData("RIGHT Module Orientation: ", robot.driveController.moduleRight.getCurrentOrientation().getAngle());
        telemetry.update();

        if (gamepad1.y) {
            robot.driveController.resetEncoders();
        }
    }
}

//you cant stop me
// ONE day We WILl alL Die
//HopEFUlly toNIghT
//iN Our SLEEp
//MEEP
//:D my poem pls gimme 100 like and subsfrieb
