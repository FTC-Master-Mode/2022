package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Basic OpMode", group = "OpMode")
public class basic_OpMode extends OpMode {
    // Declare OpMode members.
    private final ElapsedTime runtime = new ElapsedTime();
    public boolean slow = true;
    public double slowValue = .5;
    public double[] motorValues = new double[4];
    basic_hardware robot = new basic_hardware();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        robot.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {

        if (gamepad1.a) {
            slow = false;
            slowValue = 1;
        }
        if (gamepad1.b) {
            slow = true;
            slowValue = .5;
        }
        double x = (gamepad1.left_stick_x) * slowValue; // Remember, this is reversed!
        double y = gamepad1.left_stick_y * slowValue;
        double rx = gamepad1.right_stick_x * (slowValue);
        robot.SetMotors(y, x, rx);

        telemetry.addData("Y", y);
        telemetry.addData("X", x);
        telemetry.addData("RX", rx);
        telemetry.addData("Slow Mode", slow);
        telemetry.addData("MotorFL", robot.motorFrontLeft.getPower());
        telemetry.addData("MotorFR", robot.motorFrontRight.getPower());
        telemetry.addData("MotorBL", robot.motorBackLeft.getPower());
        telemetry.addData("MotorBR", robot.motorBackRight.getPower());

        telemetry.update();
        //0:FL, 1:BL, 2:FR, 3:BR

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio, but only when
        // at least one is out of the range [-1, 1]


    }
}