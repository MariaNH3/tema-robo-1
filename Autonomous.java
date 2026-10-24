package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.Opmode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//initializare piese componente
@TeleOp
public class Teleop extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo claw;
    Servo arm
    
@Override 
public void init() {
        leftMotor = hardwareMap.get(DcMotor.class, "motor_left");
        rightMotor = hardwareMap.get(DcMotor.class, "motor_right");
        arm = hardwareMap.get(Servo.class, "arm");
        claw = hardware.get(Servo.class, "claw")

TouchSensor touch;
touch = hardwareMap.get(TouchSensor.class, "touch");
boolean isPressed = touch.isPressed();

private void setDrivePower (1.0) {
   leftMotor.setPower(0.5);
   rightMotor.setPower(0.5);
}
private void closeGripper() {
   claw.setPosition(0.0);
}
private void lowArm() {
   arm.setPosition(0.0);
}
private void moveBackward (-1.0) {
   leftMotor.setPower(-0.5)
   rightMotor.setPower(-0.5)
}

// definirea starilor posibile ale robotului
public enum State{
INITIAL, 
DRIVE_FORWARD, 
LOWER_ARM,
CHECK_SENSOR,
DRIVE_BACKWARD,
IDLE
}

State currentState = State.INITIAL;

ElapsedTime timer = new ElapsedTime();


switch (currentState) {
   case INITIAL:
       time.reset();
       currentState = State.DRIVE_FORWARD;
       break; 
   case DRIVE_FORWARD:
       setDrivePower(1)
    if (timer.seconds() >= 4.0) {
        currentState = State.LOWER_ARM;
     }
        break;
   case LOWER_ARM:
       lowArm()
       if (hasReachedTarget()) {  
           currentState = State.CHECK_SENSOR;
       }
    break;
   case CHECK_SENSOR:
        if touch.isPressed {
        closeGripper() AND currentState = State.DRIVE_BACKWARD;
     }
        break;
   case DRIVE_BACKWARD:
        time.reset();
        moveBackward(-1.0);
     if (timer.seconds() >= 6.0) {
         currentState = State.IDLE;
}
   break
   }
  }
}






