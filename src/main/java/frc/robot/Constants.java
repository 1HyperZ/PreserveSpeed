// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class ChassisConstants{
    public static final int rightFrontMotorID = 1;
    public static final int rightBacktMotorID = 2;
    public static final int leftFrontMotorID = 3;
    public static final int leftBackMotorID = 4;
    public static final int xboxControllerID = 0;
    public static final double deadbandValue = 0.1;
    public static final int motorCountsPerRotation = 2048;
    public static final double wheelDiameter = 15.24;
    public static final double gearRatio = 12/1;
    public static final int wheelRotatesPerMeter = (int) (100/47.8536);
    public static final int motorCountsPerMeter = 50000;
    public static final int gyroId = 14;  
    public static final int fixedAngleErrorRange = 3;


    // Velocity PID
    public static final double KP = 512/5300;
    public static final double KI = KP/10;
    public static final double KD = 0;
  }



  




}
