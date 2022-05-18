package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;
import org.firstinspires.ftc.teamcode.basic_hardware;

@TeleOp(name = "Basic OpMode", group = "OpMode")
public class basic_OpMode extends OpMode {
    public basic_hardware robot = new basic_hardware();
    public double topPower;
    public double bottomPower;
    public double yAxis = gamepad1.left_stick_y;

    @Override
    public void init(){
        robot.init();
    }

    @Override
    public void loop() {
        if (yAxis > 0) {
            topPower =  yAxis;
            bottomPower =  (yAxis);
        } else if (yAxis < 0){
            topPower =  yAxis;
            bottomPower =  yAxis;
        } else {
            bottomPower = 0;
            topPower = 0;
        }
        robot.topMotor.setPower(topPower);
        robot.bottomMotor.setPower(bottomPower);
    }
 }
