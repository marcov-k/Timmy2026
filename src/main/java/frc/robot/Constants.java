package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public final class Constants
{
    public static final class DriveConstants
    {
        public static final int kFrontLeftMotorID = 1;
        public static final int kFrontRightMotorID = 2;
        public static final int kBackRightMotorID = 3;
        public static final int kBackLeftMotorID = 4;

        public static final double kDriveSpeedLimit = 1.0;
        public static final double kDriveDeadband = 0.02;

        public static final SparkMaxConfig kLeftMotorConfig = new SparkMaxConfig();
        public static final SparkMaxConfig kRightMotorConfig = new SparkMaxConfig();

        static
        {
            kLeftMotorConfig
                .smartCurrentLimit(50);
            
            kLeftMotorConfig.absoluteEncoder
                .inverted(true);
            
            kRightMotorConfig
                .smartCurrentLimit(50);
            
            kRightMotorConfig.absoluteEncoder
                .inverted(false);
        }
    }
}
