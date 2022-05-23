package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Advanced OpMode", group = "OpMode")
public class advance_OpMode extends OpMode {

    private final ElapsedTime runtime = new ElapsedTime();
    public boolean slow = true;
    public double slowvalue = .5;
    public double[] motorValues = new double[4];
    advanced_hardware robot = new advanced_hardware();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        robot.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
        robot.setMotors(gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}
