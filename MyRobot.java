package org.firstinspires.ftc.teamcode
    
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
// inceputul unui OpMode
@TeleOp(name = "MyRobot")
public class MyRobot extends OpMode {
    // Mapare
    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo armPivot;
    Servo claw;

    boolean Claw = gamepad1.x
    if (gamepad1.x) {
    Claw.setPosition (openClaw);
    } else {
        Claw.setPosition (closedClaw);
    
    @Override public void init() {
        leftMotor = hardwareMap.get(DcMotor.class, "motor_left");
        rightMotor = hardwareMap.get(DcMotor.class, "motor_right");
        armPivot = hardwareMap.get(Servo.class, "arm_pivot");
        claw = hardwareMap.get(Servo.class, "claw");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setPower(0.75);
        rightMotor.setPower(0.75);
       
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
            } else (gamepad1.dpad_down) {
                armPivot.setPosition(0.2);
            }

            // Afișare date pe ecranul
            telemetry.addData("Clește deschis", openClaw);
            telemetry.addData("Cleste inchis", closedClaw);
            telemetry.addData("Putere Stânga", leftMotor.getPower());
            telemetry.addData("Putere Dreapta", rightMotor.getPower());
            telemetry.addData("Pozitie Brat", armPivot.getCurrentPosition());
            telemetry.update();
        }
    }
}
