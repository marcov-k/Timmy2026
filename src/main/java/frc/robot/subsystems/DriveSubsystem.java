package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase
{
    SparkMax frontLeftMotor;
    SparkMax frontRightMotor;
    SparkMax backRightMotor;
    SparkMax backLeftMotor;

    public DriveSubsystem()
    {
        frontLeftMotor = new SparkMax(Constants.DriveConstants.kFrontLeftMotorID, MotorType.kBrushless);
        frontRightMotor = new SparkMax(Constants.DriveConstants.kFrontRightMotorID, MotorType.kBrushless);
        backRightMotor = new SparkMax(Constants.DriveConstants.kBackRightMotorID, MotorType.kBrushless);
        backLeftMotor = new SparkMax(Constants.DriveConstants.kBackLeftMotorID, MotorType.kBrushless);
    }

    public void drive(double forward, double steer)
    {
        forward = MathUtil.applyDeadband(forward * Constants.DriveConstants.kDriverSpeedLimit, Constants.DriveConstants.kDriveDeadband);
        steer = MathUtil.applyDeadband(steer * Constants.DriveConstants.kDriverTurnLimit, Constants.DriveConstants.kDriveDeadband);

        // TODO: add tank driving math
    }
}
