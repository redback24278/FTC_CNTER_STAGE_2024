package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "controller")
public class controller extends LinearOpMode {

  private DcMotor left_back;
  private DcMotor left_front;
  private DcMotor liftR;
  private Servo right_pixl_hand;
  private Servo left_pixl_hand;
  private DcMotor right_back;
  private DcMotor right_front;
  private DcMotor Intake;
  private DcMotor liftL;


  @Override
  public void runOpMode() {
    float Front_Left_Power;
    float Back_Left_Power;
    float Front_Right_Power;
    float Back_Right_Power;

    left_back = hardwareMap.get(DcMotor.class, "left_back");
    left_front = hardwareMap.get(DcMotor.class, "left_front");
    liftR = hardwareMap.get(DcMotor.class, "lift R");
    right_pixl_hand = hardwareMap.get(Servo.class, "right_pixl_hand");
    left_pixl_hand = hardwareMap.get(Servo.class, "left_pixl_hand");
    right_back = hardwareMap.get(DcMotor.class, "right_back");
    right_front = hardwareMap.get(DcMotor.class, "right_front");
    Intake = hardwareMap.get(DcMotor.class, "Intake");
    liftL = hardwareMap.get(DcMotor.class, "lift L");

    left_back.setDirection(DcMotor.Direction.REVERSE);
    left_front.setDirection(DcMotor.Direction.REVERSE);
    liftR.setDirection(DcMotor.Direction.REVERSE);
    right_pixl_hand.setDirection(Servo.Direction.REVERSE);
    left_pixl_hand.setDirection(Servo.Direction.REVERSE);
    left_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    left_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    right_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    right_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    Intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    liftR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    liftL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        Front_Left_Power = -gamepad1.right_stick_y + gamepad1.right_stick_x;
        Back_Left_Power = -gamepad1.right_stick_y - gamepad1.right_stick_x;
        Front_Right_Power = -gamepad1.right_stick_y - gamepad1.right_stick_x;
        Back_Right_Power = -gamepad1.right_stick_y + gamepad1.right_stick_x;
        if (gamepad1.right_stick_y != 0 || gamepad1.right_stick_x != 0) {
          left_back.setPower(Back_Left_Power);
          left_front.setPower(Front_Left_Power);
          right_back.setPower(Back_Right_Power);
          right_front.setPower(Front_Right_Power);
        } else {
          left_back.setPower(0);
          left_front.setPower(0);
          right_back.setPower(0);
          right_front.setPower(0);
        }
        if (gamepad1.left_stick_x != 0) {
          left_back.setPower(gamepad1.left_stick_x);
          left_front.setPower(gamepad1.left_stick_x);
          right_back.setPower(-gamepad1.left_stick_x);
          right_front.setPower(-gamepad1.left_stick_x);
        }
        if (gamepad2.right_stick_y == -1) {
          liftR.setPower(1);
          liftL.setPower(1);
        } else if (gamepad2.right_stick_y == 1) {
          liftR.setPower(-0.6);
          liftL.setPower(-0.6);
        } else {
          liftR.setPower(0);
          liftL.setPower(0);
        }
        if (gamepad2.dpad_up) {
          liftR.setPower(0.5);
          liftL.setPower(0.5);
        } else if (gamepad2.dpad_down) {
          liftR.setPower(-1);
          liftL.setPower(-1);
        } else {
          liftR.setPower(0);
          liftL.setPower(0);
        }
        if (gamepad2.left_bumper) {
          right_pixl_hand.setPosition(1);
        } else {
          right_pixl_hand.setPosition(0);
        }
        if (gamepad2.right_bumper) {
          left_pixl_hand.setPosition(0);
        } else {
          left_pixl_hand.setPosition(0.5);
        }
        if (gamepad2.a) {
          Intake.setPower(0.5);
        } else if (gamepad2.b) {
          Intake.setPower(-0.6);
        } else {
          Intake.setPower(0);
        }
        if (gamepad2.left_trigger == 1) {
          right_back.setPower(0.5);
          right_front.setPower(-0.5);
          left_front.setPower(0.5);
          left_back.setPower(-0.5);
        } else if (gamepad2.right_trigger == 1) {
          right_back.setPower(-0.5);
          right_front.setPower(0.5);
          left_front.setPower(-0.5);
          left_back.setPower(0.5);
        }
        if (gamepad2.left_stick_x == 1) {
          right_back.setPower(-0.5);
          right_front.setPower(-0.5);
          left_front.setPower(0.5);
          left_back.setPower(0.5);
        } else if (gamepad2.left_stick_x == -1) {
          right_back.setPower(0.5);
          right_front.setPower(0.5);
          left_front.setPower(-0.5);
          left_back.setPower(-0.5);
        }
        if (gamepad2.left_stick_y == 1) {
          right_back.setPower(0.5);
          right_front.setPower(0.5);
          left_front.setPower(0.5);
          left_back.setPower(0.5);
        } else if (gamepad2.left_stick_y == -1) {
          right_back.setPower(-0.5);
          right_front.setPower(-0.5);
          left_front.setPower(-0.5);
          left_back.setPower(-0.5);
        }
      }
    }
  }
}
