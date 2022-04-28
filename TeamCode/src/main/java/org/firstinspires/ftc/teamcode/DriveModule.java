package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

//DriveModule = one of the diff swerve modules
public class DriveModule {
    enum ModuleSide {LEFT, RIGHT}
    public HardwareMap hardwareMap;
    private double lastMotor1Encoder;
    private double lastMotor2Encoder;
    public final double TICKS_PER_MODULE_REV = 28 * (double)(60)/11 * (double)(48)/15 * (double)(82)/22 * 2; //ticks per MODULE revolution
    public final double DEGREES_PER_TICK = 360/TICKS_PER_MODULE_REV;

    private final ModuleSide moduleSide;
    basic_hardware robot;
    private double distanceTraveled; //distance traveled (delta s) since initial encoder state
    public final Vector2d positionVector; //position of module relative to robot COM (center of mass)

    //TODO: make sure these motors are not flipped on the  drive
    DcMotor motor1; //top motor
    DcMotor motor2; //bottom motor

    public Angle getCurrentOrientation() {
        robot.telemetry.addData(moduleSide + "Motor 1 Encoder", motor1.getCurrentPosition());
        robot.telemetry.addData(moduleSide + "Motor 2 Encoder", motor2.getCurrentPosition());
        double rawAngle = (double)(motor2.getCurrentPosition() + motor1.getCurrentPosition())* DEGREES_PER_TICK; //motor2-motor1 makes ccw positive (?)
        return new Angle(rawAngle, Angle.AngleType.ZERO_TO_360_HEADING);

    }
    public DriveModule(basic_hardware robot, ModuleSide moduleSide) {
        this.robot = robot;
        this.moduleSide = moduleSide;



        //TODO: fix hardwareMap
        if (moduleSide == ModuleSide.RIGHT) {
            motor1 = hardwareMap.dcMotor.get("RightDriveTopMotor");
            motor2 = hardwareMap.dcMotor.get("RightDriveBottomMotor");
            //TODO: change 18/2
            positionVector = new Vector2d((double)18/2, 0); //points from robot center to right module
        } else {
            motor1 = hardwareMap.dcMotor.get("LeftDriveTopMotor");
            motor2 = hardwareMap.dcMotor.get("LeftDriveBottomMotor");
            //TODO: change -18/2
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
