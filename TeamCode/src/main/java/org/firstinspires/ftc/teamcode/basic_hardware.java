package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class basic_hardware{
    public DcMotor topMotor=null;
    public DcMotor bottomMotor=null;
    public HardwareMap ahwMap;
    public OpMode opMode=null;
    
    public basic_hardware() {
        ahwMap = opMode.hardwareMap;
    }

    public void init() {
        topMotor = ahwMap.get(DcMotor.class, "topMotor");
        bottomMotor = ahwMap.get(DcMotor.class, "bottomMotor");
    }
}

