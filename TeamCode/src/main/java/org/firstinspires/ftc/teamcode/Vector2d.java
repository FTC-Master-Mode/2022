package org.firstinspires.ftc.teamcode;

public class Vector2d {
    //Vector constants
    final static Vector2d FORWARD = new Vector2d(0, 1),
            BACKWARD = new Vector2d(0, -1),
            LEFT = new Vector2d(-1, 0),
            RIGHT = new Vector2d(1, 0),
            ZERO = new Vector2d(0, 0);

    private double x;
    private double y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
        this.fixFloatingPointErrors();

    }
    public void fixFloatingPointErrors() {
        if (Math.abs(this.x) < 1e-5) {
            this.x = 0;
        }
        if (Math.abs(this.y) < 1e-5) {
            this.y = 0;
        }
    }
}
