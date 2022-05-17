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
    public double xAxis = gamepad1.left_stick_x;
    public double yAxis = gamepad1.left_stick_y;

    @Override
    public void init(){
        robot.init();
    }

    @Override
    public void loop() {
        if (yAxis != 0) {
            topPower = yAxis;
            bottomPower = yAxis - .02;
        }
        robot.topMotor.setPower(topPower);
        robot.bottomMotor.setPower(bottomPower);
    }
 }
//make so joystick does the thing when joystick move yunno liek yes :)