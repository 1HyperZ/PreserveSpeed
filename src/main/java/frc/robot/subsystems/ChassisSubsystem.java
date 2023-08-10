package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import  static frc.robot.Constants.ChassisConstants.*;

public class ChassisSubsystem extends SubsystemBase{
    
    public TalonFX rightFrontMotor = new TalonFX(rightFrontMotorID);
    public TalonFX rightBackMotor = new TalonFX(rightBacktMotorID);
    public TalonFX leftFrontMotor = new TalonFX(leftFrontMotorID);
    public TalonFX leftBackMotor = new TalonFX(leftBackMotorID);
    public PigeonIMU gyro = new PigeonIMU(gyroId);

    public ChassisSubsystem() {
        rightFrontMotor.setInverted(true);
        rightBackMotor.setInverted(true);
        leftFrontMotor.setInverted(false);
        leftBackMotor.setInverted(false);
        leftBackMotor.follow(leftFrontMotor);
        rightBackMotor.follow(rightFrontMotor);
    }

    public void setPower(double left, double right){
        rightFrontMotor.set(ControlMode.PercentOutput, right);
        leftFrontMotor.set(ControlMode.PercentOutput, left);
    }

    public void setVelocity(double left, double right){
        rightFrontMotor.set(ControlMode.Velocity, right * motorCountsPerMeter / 10);
        leftFrontMotor.set(ControlMode.Velocity, left * motorCountsPerMeter / 10);
    }
}
