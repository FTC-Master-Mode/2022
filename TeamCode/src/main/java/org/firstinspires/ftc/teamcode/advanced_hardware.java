package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class advanced_hardware {
    public DcMotor topMotor=null;
    public DcMotor bottomMotor=null;

    public void init(HardwareMap ahwmap, Telemetry t){
        topMotor=ahwmap.get(DcMotor.class, "topMotor");
        bottomMotor=ahwmap.get(DcMotor.class, "bottomMotor");
        topMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        stopMotors();
    }

    public void setMotors(double y,double x){
        topMotor.setPower(y+x);
        bottomMotor.setPower(-y-x);
    }

    public void stopMotors(){
        topMotor.setPower(0);
        bottomMotor.setPower(0);
    }
}
