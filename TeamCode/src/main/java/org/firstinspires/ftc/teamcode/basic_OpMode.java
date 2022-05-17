package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.basic_hardware;

@TeleOp(name = "Basic OpMode", group = "OpMode")
public class basic_OpMode extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();
    basic_hardware robot = new basic_hardware();
    public double topPower = 0.0;
    public double bottomPower = 0.0;

    @Override
    public void init(){
        robot.init();
    }

    @Override
    public void loop() {
        if (gamepad1.left_stick_y != 0) {
            topPower =  gamepad1.left_stick_y;
            bottomPower =  gamepad1.left_stick_y - .02;
        }
        robot.topMotor.setPower(topPower);
        robot.bottomMotor.setPower(bottomPower);
    }
 }
//make so joystick does the thing when joystick move yunno liek yes :)