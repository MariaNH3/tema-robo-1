"MyRobot.java"
package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="MyRobot")
public class MyRobot extends LinearOpMode {

    // Declararea componentelor
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    private Servo armPivot = null;
    private Servo claw = null;

    boolean claw = gamepad1.x
  

    @Override public void runOpMode() {
        // Inițializarea componentelor
        leftMotor = hardwareMap.get(DcMotor.class, "motor_left");
        rightMotor = hardwareMap.get(DcMotor.class, "motor_right");
        armPivot = hardwareMap.get(Servo.class, "arm_pivot");
        claw = hardwareMap.get(Servo.class, "claw");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setPower(0.75);

        // Poziția inițială a cleștelui (pornește închis)
        claw.setPosition(0.0); 

        telemetry.addData("Status", "Robotul este gata. Apasa Play!");
        telemetry.update();

        waitForStart();
     

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_x;  
         
            double leftPower = Range.clip(drive + turn, -1.0, 1.0);
            double rightPower = Range.clip(drive - turn,-1.0, 1.0);

            left.Motor.setPower(leftPower);
            rightMotor.setPower(rightPower);
                
            if (gamepad1.dpad_up) {
                armPivot.setPosition(0.85);
            } else if (gamepad1.dpad_down) {
                armPivot.setPosition(0.2);
            }

            // Afișare date pe ecranul
            telemetry.addData("Clește deschis:", openClaw);
            telemetry.addData("Cleste inchis", closedClaw);
            telemetry.addData("Putere Stânga", leftMotor.getPower());
            telemetry.addData("Putere Dreapta", rightMotor.getPower());
            telemetry.addData("Pozitie Brat", armPivot.getCurrentPosition());
            telemetry.update();
        }
    }
}
