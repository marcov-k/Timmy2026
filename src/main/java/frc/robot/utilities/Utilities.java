package frc.robot.utilities;

public final class Utilities
{
    public static double lerp(double start, double end, double t)
    {
        return start * (1.0 - t) + end * t;
    }
}
