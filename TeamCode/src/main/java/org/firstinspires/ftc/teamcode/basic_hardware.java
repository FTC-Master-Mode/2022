package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class basic_hardware{
    public DcMotor motorLeftTop = null;
    public DcMotor motorLeftBottom = null;
    public DcMotor motorRightTop = null;
    public DcMotor motorRightBottom = null;
    public DcMotor[] motorList=new DcMotor[4];
    public double[] motorPowers=new double[4];

    public void init(HardwareMap ahwMap, Telemetry telemetry) {
        motorLeftTop = ahwMap.get(DcMotor.class, "LeftDriveTopMotor");
        motorLeftBottom = ahwMap.get(DcMotor.class, "LeftDriveBottomMotor");
        motorRightTop = ahwMap.get(DcMotor.class, "RightDriveTopMotor");
        motorRightBottom = ahwMap.get(DcMotor.class, "RightDriveBottomMotorRear");
        motorList[0]=motorLeftTop;
        motorList[1]=motorLeftBottom;
        motorList[2]=motorRightTop;
        motorList[3]=motorRightBottom;

    }
}