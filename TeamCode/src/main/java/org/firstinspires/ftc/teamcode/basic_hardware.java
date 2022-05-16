//Test
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class basic_hardware{
    public DcMotor motorFrontLeft = null;
    public DcMotor motorBackLeft = null;
    public DcMotor motorFrontRight = null;
    public DcMotor motorBackRight = null;
    public DcMotor[] motorList=new DcMotor[4];
    public double[] motorPowers=new double[4];

    public void init(HardwareMap ahwMap, Telemetry t) {
        motorFrontLeft = ahwMap.get(DcMotor.class, "LeftDriveFront");
        motorBackLeft = ahwMap.get(DcMotor.class, "LeftDriveRear");
        motorFrontRight = ahwMap.get(DcMotor.class, "RightDriveFront");
        motorBackRight = ahwMap.get(DcMotor.class, "RightDriveRear");
        motorList[0]=motorFrontLeft;
        motorList[1]=motorBackLeft;
        motorList[2]=motorFrontRight;
        motorList[3]=motorBackRight;
        for (int i=0;i<=motorPowers.length-1;i++){
            motorPowers[i]=0.0;
        }

        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);

        StopMotors();
        // Declare our motors
        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests


    }
    public void SetMotors(double y, double x, double rx){
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        motorFrontLeft.setPower(frontLeftPower);
        motorBackLeft.setPower(backLeftPower);
        motorFrontRight.setPower(frontRightPower);
        motorBackRight.setPower(backRightPower);
    }
    public void StopMotors(){
        motorFrontLeft.setPower(0);
        motorBackLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackRight.setPower(0);
    }
}
