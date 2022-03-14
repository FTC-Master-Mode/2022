package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.basic_hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic OpMode", group="OpMode")
public class basic_OpMode extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    basic_hardware robot = new basic_hardware();
    public boolean slow;
    public double slowvalue;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        robot.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
             if (gamepad1.a) {
                 slow = true;
                 slowvalue = 0.5;
             }
             if (gamepad1.b){
                 slow = false;
                 slowvalue = 1;
             }
            double x = gamepad1.right_stick_x; // Remember, this is reversed!
            double y = -gamepad1.left_stick_x * slowvalue;
            double rx = gamepad1.left_stick_y * slowvalue;
            robot.SetMotors(y, x, rx);
            telemetry.addData("Y:", y);
            telemetry.addData("X:", x);
            telemetry.addData("RX:", rx);
            telemetry.addData("Slow Mode:", slow);
            telemetry.update();

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]


    }
}