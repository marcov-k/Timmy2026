package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;

import frc.robot.Constants;
import frc.robot.utilities.Utilities;

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

        frontLeftMotor.configure(Constants.DriveConstants.kLeftMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        backLeftMotor.configure(Constants.DriveConstants.kLeftMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        frontRightMotor.configure(Constants.DriveConstants.kRightMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        backRightMotor.configure(Constants.DriveConstants.kRightMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void drive(double forward, double steer)
    {
        forward = MathUtil.applyDeadband(forward, Constants.DriveConstants.kDriveDeadband);
        steer = MathUtil.applyDeadband(steer, Constants.DriveConstants.kDriveDeadband); 

        double speed = Math.sqrt(forward * forward + steer * steer) * Constants.DriveConstants.kDriveSpeedLimit;

        double leftThrottle = Utilities.lerp(-1.0, 1.0, Math.min(steer + 1.0, 1.0));
        double rightThrottle = Utilities.lerp(1.0, -1.0, Math.max(steer, 0.0));

        leftThrottle *= speed;
        rightThrottle *= speed;

        frontLeftMotor.set(leftThrottle);
        backLeftMotor.set(leftThrottle);
        
        frontRightMotor.set(rightThrottle);
        backRightMotor.set(rightThrottle);
    }
}
