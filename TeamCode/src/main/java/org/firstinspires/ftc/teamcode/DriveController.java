package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.robot.Robot;

public class DriveController {
    basic_hardware robot;
    DriveModule moduleLeft;
    DriveModule moduleRight;
    double robotDistanceTraveled = 0;
    double previousRobotDistanceTraveled = 0;
    double moduleLeftLastDistance;
    double moduleRightLastDistance;
    public DriveController(basic_hardware robot) {
        this.robot = robot;
        moduleLeft = new DriveModule(robot, DriveModule.ModuleSide.LEFT);
        moduleRight = new DriveModule(robot, DriveModule.ModuleSide.RIGHT);

        moduleLeftLastDistance = moduleLeft.getDistanceTraveled();
        moduleRightLastDistance = moduleRight.getDistanceTraveled();
    }
    public void resetEncoders() {
        //moduleRight.resetEncoders();
        //moduleLeft.resetEncoders();
    }
}
