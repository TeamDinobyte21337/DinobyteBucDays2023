// Package just means that this is the folder this file is located in
// Don't mess with this
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


/* @TeleOp makes it so that this opMode appears as a TeleOp mode on the driver's hubs
   "name" is just what the name shows up as on the driver's hub
   Try to keep the name the same as what the name of the file is
   Pay attention to brackets throughout the program
*/
@TeleOp (name = "Teleop")
public class Teleop extends OpMode {

// To name a Servo or a motor, just type DcMotor or Servo and then what you want to name the Servo/Motor
    DcMotor frontRightMotor;
    DcMotor backRightMotor;
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;

    DcMotor leftArmMotor;
    DcMotor rightArmMotor;


   Servo leftServo;
   Servo rightServo;

    public void init(){
        // The code within the init statement happens once you press "init" on the driver's hub.
        // This code does not loop as it only needs to be executed once

        // Hardware mapping is when you map the motors and servos to what you named them on the
        // driver's hub. Generally, you should keep what you name them in code and the driver's hub the same

        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        leftArmMotor = hardwareMap.dcMotor.get("leftArmMotor");
        rightArmMotor = hardwareMap.dcMotor.get("rightArmMotor");

         leftServo = hardwareMap.servo.get("leftServo");
         rightServo = hardwareMap.servo.get("rightServo");

        // This would also be where you reverse the direction of a motor


        //This bracket closes the init() statement since everything beyond this needs to be looped
         }
    public void loop(){
        // Within the "loop()" method, all of the code within here will constantly loop once you press play
        // To move a motor with a joystick, set its power to the joystick
        // This motor is set to the y axis of gamepad 1's left stick
        // exampleMotor.setPower(gamepad1.left_stick_y);

        // If you have multiple motors and you want to set them both to the same joystick, use a variable
        double forward = -.40*gamepad1.left_stick_y;
        double strafe = .40*gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;
        double arm = .20*gamepad2.left_stick_y;

        frontRightMotor.setPower(forward - strafe - turn);
        backRightMotor.setPower(forward + strafe - turn);
        frontLeftMotor.setPower(-forward - strafe - turn);
        backLeftMotor.setPower(-forward + strafe - turn);
        leftArmMotor.setPower(arm);
        rightArmMotor.setPower(-arm);

        // To move a servo, use an if statement

        // The first if statement sets the servo's position to 1 if "a" is pressed
         if (gamepad2.a){
             leftServo.setPosition(.25);
             rightServo.setPosition(0);
        }
         if (gamepad2.b){
             leftServo.setPosition(.25);
             rightServo.setPosition(0);
        }

        // This bracket closes the loop
    }

    // This bracket closes the whole program/class
}