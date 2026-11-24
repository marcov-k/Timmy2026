package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;

import frc.robot.Constants;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase
{
    SparkMax armMotor;
    AbsoluteEncoder armEncoder;

    public ArmSubsystem()
    {
        armMotor = new SparkMax(ArmConstants.kArmMotorID, MotorType.kBrushless);
        armMotor.configure(ArmConstants.kArmMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        
        armEncoder = armMotor.getAbsoluteEncoder();
    }

    public void moveArm(double input)
    {
        input = MathUtil.applyDeadband(input, ArmConstants.kArmDeadband);

        if (input > Constants.kEpsilon) raiseArm(input);
        else if (input < -Constants.kEpsilon) lowerArm(input);
    }

    public void raiseArm(double input)
    {
        double pos = armEncoder.getPosition();
        if (pos >= ArmConstants.kMaxAngle)
        {
            armMotor.set(0.0);
            return;
        }

        double dist = ArmConstants.kMaxAngle - pos;
        double speed = ArmConstants.kArmSpeed * input;

        if (dist > ArmConstants.kDecayStartAngle)
        {
            armMotor.set(speed);
        }
        else
        {
            speed *= (dist / ArmConstants.kDecayStartAngle);
            armMotor.set(speed);
        }
    }

    public void lowerArm(double input)
    {
        double pos = armEncoder.getPosition();
        if (pos <= ArmConstants.kMinAngle)
        {
            armMotor.set(0.0);
            return;
        }

        double dist = pos - ArmConstants.kMinAngle;
        double speed = ArmConstants.kArmSpeed * input;

        if (dist > ArmConstants.kDecayStartAngle)
        {
            armMotor.set(-speed);
        }
        else
        {
            speed *= (dist / ArmConstants.kDecayStartAngle);
            armMotor.set(-speed);
        }
    }
}
