package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public final class Constants
{
    public static final double kEpsilon = 1e-2;

    public static final class DriveConstants
    {
        public static final int kFrontLeftMotorID = 2;
        public static final int kFrontRightMotorID = 7;

        public static final double kDriveSpeed = 0.7;
        public static final double kDriveDeadband = 0.10;

        public static final SparkMaxConfig kLeftMotorConfig = new SparkMaxConfig();
        public static final SparkMaxConfig kRightMotorConfig = new SparkMaxConfig();

        static
        {
            kLeftMotorConfig
                .smartCurrentLimit(50);
            
            kLeftMotorConfig.absoluteEncoder
                .inverted(false);
            
            kRightMotorConfig
                .smartCurrentLimit(50);
            
            kRightMotorConfig.absoluteEncoder
                .inverted(false);
        }
    }

    public static final class GrabberConstants
    {
        public static final int kGrabberServoID = 0;

        public static final double kReleaseAngle = 0.0;
        public static final double kGrabAngle = 0.5;
    }

    public static final class ArmConstants
    {
        public static final int kArmMotorID = 1;

        public static final double kMinAngle = 0.1;
        public static final double kMaxAngle = 0.35;
        public static final double kBallAngle = 0.195;

        public static final double kArmSpeed = 0.2;
        public static final double kDecayStartAngle = 0.1;

        public static final double kArmDeadband = 0.1;

        public static final SparkMaxConfig kArmMotorConfig = new SparkMaxConfig();

        static
        {
            kArmMotorConfig.smartCurrentLimit(50);
            kArmMotorConfig.inverted(false);
            kArmMotorConfig.idleMode(IdleMode.kBrake);
        }
    }
}
