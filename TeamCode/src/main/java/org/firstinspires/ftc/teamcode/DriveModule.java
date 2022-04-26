package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;

//DriveModule = one of the diff swerve modules
public class DriveModule {
    enum ModuleSide {LEFT, RIGHT}
    public HardwareMap hardwareMap;
    private double lastMotor1Encoder;
    private double lastMotor2Encoder;

    private final ModuleSide moduleSide;
    basic_hardware robot;
    private double distanceTraveled; //distance traveled (delta s) since initial encoder state
    public final Vector2d positionVector; //position of module relative to robot COM (center of mass)

    //TODO: make sure these motors are not flipped on the  drive
    DcMotor motor1; //top motor
    DcMotor motor2; //bottom motor


    public DriveModule(basic_hardware robot, ModuleSide moduleSide) {
        this.robot = robot;
        this.moduleSide = moduleSide;



        //TODO: fix hardwareMap
        if (moduleSide == ModuleSide.RIGHT) {
            motor1 = hardwareMap.dcMotor.get("RightDriveTopMotor");
            motor2 = hardwareMap.dcMotor.get("RightDriveBottomMotor");
            positionVector = new Vector2d((double)18/2, 0); //points from robot center to right module
        } else {
            motor1 = hardwareMap.dcMotor.get("LeftDriveTopMotor");
            motor2 = hardwareMap.dcMotor.get("LeftDriveBottomMotor");
            positionVector = new Vector2d((double)-18/2, 0); //points from robot center to left module
        }
        lastMotor1Encoder = motor1.getCurrentPosition();
        lastMotor2Encoder = motor2.getCurrentPosition();

        //setting run mode to NOT use encoders for velocity PID regulation
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public double getDistanceTraveled () {
        return distanceTraveled;
    }
}
