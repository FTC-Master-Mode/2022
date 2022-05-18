package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class basic_hardware{
    public DcMotor topMotor;
    public DcMotor bottomMotor;
    public HardwareMap ahwMap;


    public void init() {
        topMotor = ahwMap.get(DcMotor.class, "topMotor");
        bottomMotor = ahwMap.get(DcMotor.class, "bottomMotor");
    }
}
//
//noAh IS bAD
// he MAKEs mE SaD
// dIE DIe diE DIe
// piE pie EPIpipipipipi
//ppe pepeeoeoeoepepeooooooooo
//HOORAY ONE DAY WE ALL DIE
//ONE DAY WE HAVE AN ALLERGIC REACTION TO PI
//MATH IS FUN
//I HATE YOU
//IDK WHAT RHYMES WITH YOU
//HELP ME
//<3